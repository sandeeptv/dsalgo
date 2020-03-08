package com.test.example;

public class SearchRotatedSortedArray {


    public static int search(int[] arr , int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            //6,7,8,0,1,2,3,4,5
            if (arr[mid] < arr[start]) {

                if (target < arr[mid] || target >= arr[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {
                //2,3,4,5,6,7,8,0,1
                if (target > arr[mid] || target < arr[start]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }

        return -1;
    }

    public static void main(String[] args) {

        int search = search(new int[]{2, 3, 4, 5, 6, 7, 8, 0, 1}, 2);
        System.out.println(search);
    }
}
