package com.dsalgo.problems;

/**
 * Created by stuppad on 1/28/19.
 */
public class ReverseInteger {

    public static void main(String[] args) {

        System.out.println(reverse2(

                1463847412));
    }
    public static int reverse(int x) {
        boolean isNeg = false;

        if(x<0){
            isNeg = true;
        }

        if(x==0 || (x>0 && x<10)){
            return x;
        }
        String input = String.valueOf(x);
        char[] inCh = input.toCharArray();
        int length = inCh.length;
        char[] outCh = new char[length];
        int j=0;
        if(isNeg){
            outCh[0] = '-';
            j =1;

        }
        for(int i = length -1; i>=0; i--){
            outCh[j] = inCh[i];
            j++;
        }
        String output = new String(outCh);
        return Integer.valueOf(output);
    }

    public static int reverse2(int x) {
        boolean isNeg = false;
        int output = 0;

        if(x<0){
            isNeg = true;
            x = -x;
        }
        if(x== Integer.MAX_VALUE || x== Integer.MIN_VALUE){
            return 0;
        }

        if(x==0){
            return x;
        }

        while(x>=10) {
            int rem = x % 10;

            x = x / 10;
            if(Integer.MAX_VALUE/10 < (output + rem) ){
                return 0;
            }
            output = (output + rem) * 10;
        }

        output += x;
        if(isNeg){
            output = -output;
        }

        return output;
    }
}
