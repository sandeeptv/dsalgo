package com.dsalgo.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class ArraySubsequence {

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
        System.out.println(subarraysDivByK(new int[]{5,10,9,11,15}, 5));
    }

    /*
   Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.

   Example 1:

   Input: A = [4,5,0,-2,-3,1], K = 5
   Output: 7
   Explanation: There are 7 subarrays with a sum divisible by K = 5:
   [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
    */
    public static int subarraysDivByK(int[] A, int K) {


        /*
        For e.g. in case of the array [23,2,6,4,7]
        the running sum is [23,25,31,35,42] and the remainders are [5,1,1,5,0].

        We got remainder 5 at index 0 and at index 3.
        That means, in between these two indexes we must have added a number which is multiple of the k.)

         */
        Map<Integer,Integer> countMap = new HashMap<>();

        int sum = 0;
        int count = 0;
        countMap.put(0,1);
        for(int num:  A){

            sum += num;
            sum = sum % K;

            if(sum<0){
                sum +=K;
            }
            count+= countMap.getOrDefault(sum, 0);
            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);

        }
        return count;
    }



    public boolean checkSubarraySum(int[] nums, int k) {


        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, -1);
        int sum = 0;

        for(int i =0 ; i< nums.length ; i++){
            sum += nums[i];
            if(k !=0 ){
                sum = sum % k;
            }

            Integer val = count.get(sum);

            if(val != null){
                if( i - val>1){
                    return true;
                }else{
                    count.put(sum, i);
                }
            }
        }
        return false;
    }
}
