package com.test.example;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by stuppad on 2019-06-27.
 */
public class Palindrome {

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        assertTrue(palindrome.isPalindrome(121));
        assertFalse(palindrome.isPalindrome(-121));
        assertTrue(palindrome.isPalindrome(1));
        assertTrue(palindrome.isPalindrome(1001));
    }

    public boolean isPalindrome(int x) {

        String input = String.valueOf(x);
        if(input.length() ==1){
            return true;
        }
        int j = input.length() -1;
        for(int i=0;i<input.length()/2;i++){

            if(input.charAt(i) != input.charAt(j)){
                return false;
            }
            j--;
        }
        return true;
    }

}
