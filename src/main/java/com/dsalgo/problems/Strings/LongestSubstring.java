package com.dsalgo.problems.Strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    /**
    Given a string, find the length of the longest substring without repeating characters.

     Input: "abcabcbb"
     Output: 3
     Explanation: The answer is "abc", with the length of 3.
     */
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcdefgah"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
