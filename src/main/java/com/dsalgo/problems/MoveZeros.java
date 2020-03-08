package com.dsalgo.problems;

import java.util.Arrays;

/**
 * Created by stuppad on 1/31/19.
 */
public class MoveZeros {

    public static void main(String[] args) {
        MoveZeros mv = new MoveZeros();
        int[] input = {1, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, 0, 3,8,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9, 12};
        mv.moveZeroes(input);
        Arrays.stream(input).forEach( e -> System.out.println(e));

    }


    public void moveZeroes(int[] nums) {

        int ind = 0;
        for(int i=0; i<nums.length ; i++) {
            if (nums[i] != 0) {
                nums[ind++] = nums[i];
            }
        }
                for(int j=ind; j< nums.length; j++){

                        nums[j] = 0;

                }


    }
}
