package com.dsalgo.problems.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {


    public static void main(String[] args) {
        RunningMedian rm = new RunningMedian();

        Arrays.stream( new int[]{17,55,66,77,88,66,77,66,55,44,3,4,5,6,6}).forEach( e ->{
                rm.addNum(e);
        rm.addNum2(e);
        });

        System.out.println(rm.findMedian());
        System.out.println(rm.findMedian2());

    }
    /** initialize your data structure here. */

    PriorityQueue<Integer> hi = new PriorityQueue<>();
    PriorityQueue<Integer> lo = new PriorityQueue<>(Comparator.reverseOrder());

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.poll());

        if(lo.size() < hi.size() ){
            lo.offer(hi.poll());
        }

    }

    public double findMedian() {
        if(lo.size()>hi.size()){
            return lo.peek();
        }else{
            return (lo.peek() + hi.peek()) * 0.5;
        }

    }

    // 0 , 3,  7, 8, 9
    public void addNum2(int num){

        if(num < findMedian2() ){
            maxHeap.offer(num);
        }else {
            minHeap.offer(num);
        }

        if(maxHeap.size() - minHeap.size() >1){
            minHeap.offer(maxHeap.poll());
        }
        if(minHeap.size() - maxHeap.size()>0){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian2(){

        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }else {
            double max = maxHeap.peek() == null ? 0 :maxHeap.peek() ;
            double min = minHeap.peek() == null ? 0 :minHeap.peek();
            return (max + min) /2 ;
        }
    }
}
