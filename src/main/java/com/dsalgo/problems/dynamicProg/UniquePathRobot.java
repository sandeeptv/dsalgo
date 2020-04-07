package com.dsalgo.problems.dynamicProg;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 */
public class UniquePathRobot {


    public static void main(String[] args) {

        String s = "abc";

        Integer.valueOf(s.charAt(0));

        System.out.println(uniquePaths(7,3));
    }
    public static int uniquePaths(int m, int n) {

        int [][]dp = new int[m][n];

        //to reach the the last element in the column, there's only one way
        // i.e. to keep going down, so fill the first column with 1
        for (int i = 0; i < dp.length ; i++) {
            dp[i][0] = 1;

        }
        //to reach the the last element in the row, there's only one way
        // i.e. to keep going right, so fill the first row with 1
        for (int i = 0; i < dp[0].length ; i++) {
            dp[0][i] = 1;

        }
        //Now to fill the rest of the array, to reach the any box in the array,
        // there are two way we could have reached the box,  one from top and one from left
        // as we can only move down or right. so just add those values for the current position

        for(int i=1; i<m;i++){
            for (int j = 1; j < n; j++) {

                //current pos = top + left
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int [][]dp = new int[m][n];


        for (int i = 0; i < dp.length ; i++) {

            if (obstacleGrid[i][0] == 1) {
                while (i < dp.length) {
                    dp[i][0] = 0;
                    i++;
                }
            }else {
                dp[i][0] = 1;
            }

        }

        for (int i = 0; i < dp[0].length ; i++) {
            if (obstacleGrid[0][i] == 1) {

                while (i < dp[0].length) {
                    dp[0][i] = 0;
                    i++;
                }
            }else{
                dp[0][i] = 1;

            }

        }
        //Now to fill the rest of the array, to reach the any box in the array,
        // there are two way we could have reached the box,  one from top and one from left
        // as we can only move down or right. so just add those values for the current position

        for(int i=1; i<m;i++){
            for (int j = 1; j < n; j++) {

                if(obstacleGrid[i][j]!=1) {
                    //current pos = top + left
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m-1][n-1];
    }

}
