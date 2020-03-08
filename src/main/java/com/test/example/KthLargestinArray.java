package com.test.example;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestinArray {

    public static void main(String[] args) {

        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(findKthLargestPQ(new int[]{3,2,1,5,6,4,8,7}, 2));
    }


    public static int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    public static int findKthLargestPQ(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        //Keep the size of the queue equal to k
        for(int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
