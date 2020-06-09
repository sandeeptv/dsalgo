package com.dsalgo.problems.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> res = new HashMap<>();

        for(String str : strs){

            char[] input =  str.toCharArray();
            Arrays.sort(input);
            String sorted = new String(input);

            res.putIfAbsent(sorted, new ArrayList<String>());
            res.get(sorted).add(str);

        }

        List<List<String>> result = new ArrayList<>(res.values());

        return result;

    }
}
