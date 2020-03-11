package com.dsalgo.problems;

public class StringToInteger {


    public static void main(String[] args) {

        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("     -43"));
    }


    public int myAtoi(String str) {

        str = str.trim();
        char[] chars = str.toCharArray();
        if(!isValid(chars)){
            return 0;
        }
        String extract = extract(str.toCharArray());
        boolean isNeg = false;
        int count = 0;

        if (extract.charAt(0) == '-' || extract.charAt(0) == '+'){
            count++;
            if(extract.charAt(0) == '-'){
                isNeg = true;
            }
        }
        int output = 0;
        while(count<extract.length()){

            output *= 10;
            output+= extract.charAt(count) - '0';

            count ++;

        }
        if(isNeg){
            return -output;
        }
        return output;
    }

    private boolean isValid(char[] chars){

        if(chars[0] == ' ' || chars[0] == '+'
                || chars[0] == '-' || ( chars[0] > 47 && chars[0] <58) ){
            return true;
        }
        return false;

    }

    private String extract(char[] chars){

        int i =0;
        if (chars[0] == '+'
                || chars[0] == '-'){

            i =1;
        }
        for ( ; i < chars.length; i++) {
            if ( chars[i] < 47 || chars[i] >58){

               return  String.valueOf(chars, 0, i);
            }

        }
        return String.valueOf(chars);
    }
}
