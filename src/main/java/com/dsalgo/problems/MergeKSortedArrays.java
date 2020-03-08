package com.dsalgo.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    class Array{

        public int[] getVal() {
            return val;
        }

        public void setVal(int[] val) {
            this.val = val;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        private int [] val;
        private int index;

        Array(int[] val){
            this.val = val;
        }
    }

    public int[] mergeKSortedArray(int[][] arr) {

        if(arr ==null || arr.length == 0){
            return null;
        }


        int resInd = 0;
        int total = 0;
        PriorityQueue<Array> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.getVal()[a.getIndex()]));
        for(int i=0; i<arr.length; i++){
            Array array = new Array(arr[i]);

            queue.add(array);
            total = total + arr[i].length;
        }
        int [] res = new int[total];
        while (!queue.isEmpty()){
            Array array = queue.poll();
            res[resInd++] = array.getVal()[array.getIndex()];

            if(array.getIndex()<array.getVal().length-1){
                array.setIndex(array.getIndex()+1);
                queue.add(array);
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        MergeKSortedArrays ms = new MergeKSortedArrays();

        int[] result = ms.mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
        System.out.println(Arrays.toString(result));
    }

}
