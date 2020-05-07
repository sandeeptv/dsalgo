package com.dsalgo.problems.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {


    public static void main(String[] args) {

        int [] [] input = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

        System.out.println(spiralOrder(input));

    }
    public static List<Integer> spiralOrder(int[][] matrix) {

        int rowStart=0;
        int colStart=0;
        int m = matrix.length;
        int rowEnd= m -1;
        int n = matrix[0].length;
        int colEnd= n -1;

        List<Integer> res = new ArrayList<>();

        while(rowStart <= rowEnd && colStart <= colEnd){

            for (int i = rowStart; i <=colEnd && res.size()<m*n ; i++) {
                res.add(matrix[rowStart][i]);
            }
            rowStart++;

            for (int i = rowStart; i <=rowEnd && res.size()<m*n; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            for (int i = colEnd; i >=colStart && res.size()<m*n ; i--) {
                res.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            for (int i = rowEnd; i >=rowStart && res.size()<m*n ; i--) {
                res.add(matrix[i][colStart]);
            }
            colStart++;
        }

        return  res;
    }
}
