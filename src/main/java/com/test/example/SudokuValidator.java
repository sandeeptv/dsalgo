package com.test.example;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {


    public static void main(String[] args) {
        String[][] input = {{"8", "3", ".", ".", "7", ".", ".", ".", "."}
                , {"6", ".", ".", "1", "9", "5", ".", ".", "."}
                , {".", "9", "8", ".", ".", ".", ".", "6", "."}
                , {"8", ".", ".", ".", "6", ".", ".", ".", "3"}
                , {"4", ".", ".", "8", ".", "3", ".", ".", "1"}
                , {"7", ".", ".", ".", "2", ".", ".", ".", "6"}
                , {".", "6", ".", ".", ".", ".", "2", "8", "."}
                , {".", ".", ".", "4", "1", "9", ".", ".", "5"}
                , {".", ".", ".", ".", "8", ".", ".", "7", "9"}};

        System.out.println(isValidSudoku(input));

    }

    public static boolean isValidSudoku(String[][] board) {

        Set<String> rowset = new HashSet<>();

        for(int i=0 ; i<9 ; i++){

            for( int j=0 ; j <9 ; j ++){

                if(board[i][j] != "."
                        && (!rowset.add(board[i][j] + " seen row " + i)
                        || !rowset.add(board[i][j] + " seen col " + j)
                        || !rowset.add(board[i][j] + " seen box " + i/3 + "-"+j/3))){
                    return false;
                }
            }
        }
        return true;

    }


}
