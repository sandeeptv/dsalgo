package com.test.example;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class HammingDistance {
    public static void main(String[] args) {

        hammingDistance(1,4);
       findPeakElement(new int[] {1,2,1,3,5,6,4});
        repeatedSubstringPattern("abab");
        merge2(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }

    public static int hammingDistance(int x, int y) {

        String binX =  Integer.toBinaryString(x);
        String biny =  Integer.toBinaryString(y);
        int diff = 0;
        for (int i=0 ; i<binX.length(); i++){
            if(binX.charAt(i) != biny.charAt(i)){
                ++diff;
            }
        }
        return diff;
    }

    public static int findPeakElement(int[] nums) {
        for(int i=0 ; i<nums.length -2 ; i++){

            if((nums[i] < nums[i+1]) && (nums[i+1]> nums[i+2])){
                return i+1;
            }

        }
        return 0;
    }

    public static boolean repeatedSubstringPattern(String s) {

        int length =  s.length();
        int max = length/2;

        for(int i=1 ; i<=max ; i++){
            StringBuilder sb = new StringBuilder();
            String temp = s.substring(0,i);
            while(sb.length() < length){
                sb.append(temp);
            }
            if(sb.toString().equals(s)){
                return true;
            }
        }
        return false;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int j=0,k=0;
        for(int i=0; i<nums1.length; i++){

            if(nums1[i]<nums2[j]){
                if(nums1[i] == 0){
                    nums1[i] = nums2[j];
                    j++;
                }


            }else if(nums1[i]>nums2[j]){
                System.arraycopy(nums1,i,nums1,i+1,m-i);
                nums1[i] = nums2[j];
                j++;

            }else{
                System.arraycopy(nums1,i,nums1,i+1,m);
                nums1[i] = nums2[j];
                i++;
                j++;
            }
        }


    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }




}
