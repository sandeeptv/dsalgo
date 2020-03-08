package com.dsalgo.problems;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    private Queue<Integer> queue;
    private int maxSize;
    private double sum;

    public MovingAverage(int size){
        queue = new LinkedList<>();
        maxSize = size;
        sum = 0.0;
    }

    public double next(int n){

        if(queue.size() == maxSize){
            sum -= queue.poll();
        }
        queue.offer(n);
        sum += n;
        return sum/queue.size();
    }
}
