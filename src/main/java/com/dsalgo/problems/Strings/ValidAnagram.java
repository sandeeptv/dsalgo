package com.dsalgo.problems.Strings;

import java.util.HashMap;

public class ValidAnagram {


    /**
     *
     * Given two strings s and t , write a function to determine if t is an anagram of s.
     *
     * Example 1:
     *
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * Example 2:
     *
     * Input: s = "rat", t = "car"
     * Output: false
     */
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> smap=new HashMap<>();
        int sl=s.length();
        int tl=t.length();
        if(sl!=tl){return false;}
        for(int i=0;i<sl;i++){
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
            smap.put(t.charAt(i),smap.getOrDefault(t.charAt(i),0)-1);
        }
        for(char c:smap.keySet()){
            if(smap.get(c)!=0){return false;}
        }

        return true;
    }


    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
    public static boolean isPalindrome(String s) {

        int j = s.length()-1;
        for(int i=0 ; i<s.length()/2; i++){

            if (!Character.isLetterOrDigit(s.charAt(i))) {
                continue;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }else {
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                    return false;
                }
                j--;
            }

        }
        return true;
    }
}
