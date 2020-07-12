package com.dsalgo.problems.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SquareBikeRace {

        public static void main(String[] args) {


            SquareBikeRace sol = new SquareBikeRace();

            String [][] input = new String [][] {
                    {"lorenzo", "hayden", "dovizioso", "rossi", "marquez"},
                    {"marquez", "hayden", "rossi", "dovizioso", "lorenzo"},
                    {"rossi", "lorenzo", "dovizioso", "hayden", "marquez"},
                    {"dovizioso", "marquez", "rossi", "lorenzo", "hayden"},
                    {"marquez", "dovizioso", "rossi", "lorenzo", "hayden"},
                    {"marquez", "dovizioso", "hayden", "rossi", "lorenzo"},
                    {"marquez", "dovizioso", "hayden", "lorenzo", "rossi"},
                    {"marquez", "rossi", "lorenzo", "hayden", "dovizioso"},
                    {"lorenzo", "marquez", "rossi", "dovizioso", "hayden"},
                    {"marquez", "dovizioso", "hayden", "lorenzo", "rossi"}
            };

            sol.calculatePoints(input);

        }


        public void calculatePoints(String [][] results){

            List<Integer> points = Arrays.asList(15,10,5,0,0);
            Map<String,Integer> finalPoints = new HashMap<>();

            Queue<Map.Entry<String,Integer>> maxHeap =
                    new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

            int currentRace = 1 ;
            int totalRaces = results.length;

            for(String[] result : results){

                System.out.println("-----After race = " + currentRace);

                for(int i=0 ; i<5; i++){

                    finalPoints.put(result[i], finalPoints.getOrDefault(result[i], 0) + points.get(i));


                }

                finalPoints.entrySet().forEach( e -> {

                    maxHeap.add(e);
                });

                int top = 0;

                int maxRaminingPoints = 15 * (totalRaces - currentRace);

                System.out.println(totalRaces + " " + currentRace + " " + maxRaminingPoints );
                Map.Entry<String,Integer> currTopStanding = maxHeap.peek();
                top = currTopStanding.getValue();

                //to compare only with the second position
                int counter = 0;

                boolean championFound= false;
                while(!maxHeap.isEmpty()){

                    Map.Entry<String,Integer> standing =  maxHeap.poll();
                    counter++;


                    if(top - standing.getValue() > maxRaminingPoints && counter ==2){
                        championFound = true;

                    }
                    System.out.println(standing.getKey() + " : " + standing.getValue());
                }

                if(championFound){
                    System.out.println(currTopStanding.getKey() + " is the champion");
                }

                currentRace ++;

            }

            // finalPoints.forEach((k,v) -> System.out.println(k + " : " + v));

        }

}
