package com.dsalgo.problems.dynamicProg;

public class DecodeWays {

    public static void main(String[] args) {

        System.out.println(numDecodings("226"));
    }
    public static int numDecodings(String s) {

        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'?0:1;
        for(int i =2; i<= len ; i++){

            int firstVal = Integer.valueOf(s.substring(i-1,i));
            int secondVal = Integer.valueOf(s.substring(i-2,i));
            if(firstVal>0 && firstVal < 10){
                dp[i] += dp[i-1];
            }
            if(secondVal>=10 && secondVal <=26){
                dp[i] += dp[i-2];
            }
        }

        return dp[len];
    }
}
