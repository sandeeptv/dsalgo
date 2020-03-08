package com.test.example.other;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaxToys {

    public static void main(String[] args) {


        System.out.println(maxToys( new int[] {3, 12, 5, 111, 200, 1000, 10, 9, 12, 15}, 2));
    }

    public static int maxToys(int[] arr, int k){

        PriorityQueue<Integer> queue = new PriorityQueue<>();


         Arrays.stream(arr).forEach(e-> queue.add(e));
         int count = 0 ;
         while(!queue.isEmpty()){

             k-=queue.poll();
             if(k<0){
                 break;
             }
             count++;

         }
         return count;

    }
}
