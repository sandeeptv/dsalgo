package com.dsalgo.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by stuppad on 1/29/19.
 */
public class TestClass {


    public static void main(String[] args) {

        jumpingOnClouds(new int[]{0 ,0, 0, 1, 0, 0});

        System.out.println(firstUniqChar("Aeetcode"));

        PriorityQueue<Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Entry<Character, Integer> fdfd ;
        Entry<Character, Integer> poll = pq.poll();
//        poll.getValue();

        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));


    }


    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0,j=0,k=0;
        while(i<nums1.length && j <nums2.length){

            if(nums1[i] == nums2[j]){
//                out[k] = nums1[i];
                ++k;
                ++i;
                ++j;
            }else if(nums1[i] < nums2[j]){
                ++i;
            }else{
                ++j;
            }


        }
        int[] out = new int[k];

        i=0;j=0;k=0;
        while(i<nums1.length && j <nums2.length){

            if(nums1[i] == nums2[j]){
                out[k] = nums1[i];
                ++k;
                ++i;
                ++j;
            }else if(nums1[i] < nums2[j]){
                ++i;
            }else{
                ++j;
            }


        }
        return out;
    }

    static int jumpingOnClouds(int[] c) {

        int path = 0;
        for(int i=0 ; i <c.length-1; i++ ){
            if(i+2 <c.length ){
                if(c[i+2] !=1){

                    i = i+1;
                }

            }
            ++path;

        }
        return path;
    }

    static long arrayManipulation(int n, int[][] queries) {

        int[] res = new int[10];

        for(int i =0 ; i< queries.length; i++){

            int start = queries[i][0] -1;
            int end = queries[i][1] -1;
            int delta = queries[i][2];

            for (int j=start ; j<=end ; j++){
                res[j] +=delta;
            }

        }
        return Long.valueOf(Arrays.stream(res).max().getAsInt());
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();


        for(int i =0 ; i<s.length(); i++){
            int i1 = s.charAt(i) - 'a';
            count.putIfAbsent(s.charAt(i), 0);
            count.computeIfPresent(s.charAt(i), (k,v) -> ++v);
        }

        for(int i =0 ; i<s.length(); i++){
            if( count.get(s.charAt(i)) == 1){
                return i;
            }

        }
        return 0;
    }


    public static boolean wordBreak(String s, List<String> wordDict) {


        for (String word : wordDict) {

            if (s.contains(word)) {
                int start = s.indexOf(word);
                int end = start + word.length();
                String substring = s.substring(start, end);
                s = s.replaceAll(substring, "");
            }

        }
        if (s.length() == 0) {
            return true;
        }
        return false;
    }

    }
