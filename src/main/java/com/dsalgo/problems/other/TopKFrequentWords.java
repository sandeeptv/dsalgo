package com.dsalgo.problems.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class TopKFrequentWords {

    public static void main(String[] args) {
        List<String> strings = topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 1);
        List<String> strings2 = topKFrequentPQ(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 1);
        System.out.println(strings);
        System.out.println(strings2);
    }

    public static List<String> topKFrequent(String[] words, int k) {

        Map<String,Integer> count = new HashMap<>();

        Arrays.stream(words).forEach(s -> count.put(s , count.getOrDefault(s, 0) +1));

        Set<String> [] freqList = new TreeSet[count.size() +1];

        count.forEach((m,v) ->{
            if(freqList[v] == null){
                Set<String> strSet =  new TreeSet<>();
                freqList[v] = strSet;
            }
            freqList[v].add(m);

        });

        List<String> result = new ArrayList<String>();
        for(int i=freqList.length-1 ; i>=0  && result.size()<k; i--){

            if(freqList[i] !=null) {
                result.addAll(freqList[i]);
            }

        }
        return result.subList(0, k);
    }


    public static List<String> topKFrequentPQ(String[] words, int k) {

        Map<String,Integer> count = new HashMap<>();

        Arrays.stream(words).forEach(s -> count.put(s , count.getOrDefault(s, 0) +1));

        Queue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() == b.getValue() ?
                b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

        count.entrySet().forEach( e ->{
            minHeap.add(e);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        });


        List<String> result = new ArrayList<String>();

        while (!minHeap.isEmpty()){
            result.add(minHeap.poll().getKey());
        }

        return result;
    }

}
