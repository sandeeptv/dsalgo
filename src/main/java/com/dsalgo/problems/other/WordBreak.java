package com.dsalgo.problems.other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordBreak {


    public static void main(String[] args) {

        List<String> strings = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak("catsandog", new HashSet<>(strings)));
    }

    public static boolean wordBreak(String s, Set<String> dict) {

        if (dict.contains(s)){
            return true;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        // use a set to record checked index to avoid repeated work.
        // This is the key to reduce the running time to O(N^2).
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(0);
        while (!queue.isEmpty()) {
            int curIdx = queue.poll();
            for (int i = curIdx+1; i <= s.length(); i++) {
                if (visited.contains(i)) continue;
                if (dict.contains(s.substring(curIdx, i))) {
                    if (i == s.length()) return true;
                    queue.offer(i);
                    visited.add(i);
                }
            }
        }
        return false;
    }

    public static boolean wordBreakDp(String s, Set<String> dict){
        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;

        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }
}
