package com.dsalgo.problems;

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


    /**
     * The basic idea is to use Quick Select algorithm to partition the array with pivot:
     *
     * Put numbers < pivot to pivot's left
     * Put numbers > pivot to pivot's right
     * Then
     *
     * if indexOfPivot == k, return A[k]
     * else if indexOfPivot < k, keep checking right part to pivot
     * else if indexOfPivot > k, keep checking left part to pivot
     * Time complexity = O(n)
     *
     * Discard half each time: n+(n/2)+(n/4)..1 = n + (n-1) = O(2n-1) = O(n), because n/2+n/4+n/8+..1=n-1.
     *
     *
     * Input: [3,2,1,4,5,6], k = 2
     * The sorted version: [1,2,3,4,5,6]
     *
     * The first largest element k = 1 is 6
     * The second largest element k = 2 is 5
     *
     * Finding the kth largest element is the same as asking for the element at index (length - k) in the sorted array.
     * In the above example:
     * • length = 6
     * • k = 2
     * • desired item is at index 6-2 = 4 in the sorted array
     *
     * Btw - the index is 0-based, k is not though. This index is in terms of the sorted array and from left to right.
     *
     * This then allows you do use the idea of quicksort which is a solved problem and relies on the principle of moving
     * to a state where all items less than the partition are to the left and all items greater than the partition are to the right.
     * Your goal is to get that partition to the same spot as (length - k)
     */
    public int findKthLargestQuickSelect(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    public int findKthLargest(int[] nums, int start, int end, int k) {// quick select: kth smallest
        if (start > end) return Integer.MAX_VALUE;

        int pivot = nums[end];// Take A[end] as the pivot,
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
                swap(nums, left++, i);
        }
        swap(nums, left, end);// Finally, swap A[end] with A[left]

        if (left == k)// Found kth largest number
            return nums[left];
        else if (left < k)// Check right part
            return findKthLargest(nums, left + 1, end, k);
        else // Check left part
            return findKthLargest(nums, start, left - 1, k);
    }

    void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
