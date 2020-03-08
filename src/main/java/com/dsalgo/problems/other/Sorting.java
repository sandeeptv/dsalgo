package com.dsalgo.problems.other;

import java.util.Arrays;

/**
 * Created by meg on 5/15/17.
 */
public class Sorting {


    public static void main(String[] args) {
        selectionSort();
        insertionSort();
        System.out.println(Arrays.toString(quickSort(new int[] {4, 3, 6, 56, 14, 16, 7, 8, 24})));
    }

    public static void selectionSort() {
        int[] inputArr = {4, 3, 6, 56, 14, 16, 7, 8, 24};

        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i; j < inputArr.length; j++) {

                if (inputArr[j] < inputArr[i]) {
                    int temp = inputArr[j];
                    inputArr[j] = inputArr[i];
                    inputArr[i] = temp;
                }

            }
        }

        System.out.println(Arrays.toString(inputArr));
    }

    public static void insertionSort() {
        int[] inputArr = {4, 3, 6, 56, 14, 16, 7, 8, 24};

        for (int i = 1; i < inputArr.length; i++) {
            for (int j = 0; j < i; j++) {

                if (inputArr[i] < inputArr[j]) {
                    int temp = inputArr[j];
                    inputArr[j] = inputArr[i];
                    inputArr[i] = temp;
                }

            }
        }

        System.out.println(Arrays.toString(inputArr));
    }

    public static int[] quickSort(int[] data){

        if(data.length<2){
            return data;
        }
        int pivot = data.length/2;
        int pivVal = data[pivot];

        int left = 0;
        for (int i = 0; i <data.length ; i++) {
            if(data[i]<pivVal){
                left++;
            }

        }
        int[] leftArr = new int[left];
        int[] righArr = new int[data.length-left-1];

        int l=0,r=0;
        for (int i = 0; i <data.length ; i++) {
            if(i==pivot) continue;
            if(data[i]<pivVal){
                leftArr[l++]=data[i];
            }else{
                righArr[r++]=data[i];
            }
        }

        leftArr=quickSort(leftArr);
        righArr=quickSort(righArr);

        System.arraycopy(leftArr,0,data,0,leftArr.length);
        data[leftArr.length]=pivVal;
        System.arraycopy(righArr,0,data,leftArr.length+1,righArr.length);

        return data;
        }

}