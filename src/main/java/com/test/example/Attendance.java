package com.test.example;

public class Attendance {

    public static void main(String[] args) {
        System.out.println(checkRecord("AA"));
    }
    public static boolean checkRecord(String s) {

        int absentCount = 0;
        char[] chars = s.toCharArray();
        for(int i=0 ;  i< chars.length; i++ ){


            if(chars[i] == 'A'){
                absentCount++;
            }
            if(chars[i] == 'L'){
                if( i + 2 < chars.length){
                    if(chars[i+1] == 'L'&& chars[i+2] == 'L'){
                        return false;
                    }
                }

            }
            if(absentCount>1){
                return false;
            }
        }

        return true;
    }
}
