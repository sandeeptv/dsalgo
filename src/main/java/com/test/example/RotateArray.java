package com.test.example;

import javax.sound.midi.Soundbank;

/**
 * Created by stuppad on 1/29/19.
 */
public class RotateArray {

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] inp = new int[]{1,2,3};
        rotateArray.rotate(inp, 2);
        System.out.println(inp);
    }

    public void rotate(int[] nums, int k) {
        int out [] = new int[nums.length];
        for(int i = 0 ; i<nums.length; i ++ ){


            out[(i+k) % nums.length] = nums[i];

        }
        for(int i = 0 ; i<nums.length; i ++ ){
            nums[i] = out[i];
        }

    }

    public void rotate2(int[] nums, int k) {
       int temp = 0;
        for(int i = 0 ; i<nums.length; i ++ ){

            if(i==0){
                temp = nums[i];
            }
            if(k>=nums.length -1){
                k= k % (nums.length -1);
            }
            temp = nums[k];
            nums[k] = nums[i];
            k+=k;
        }

    }
}
