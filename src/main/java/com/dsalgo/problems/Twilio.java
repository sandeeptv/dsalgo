package com.dsalgo.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Twilio {

    public static void main(String[] args) {
       String s = "Python is an easy to learn powerful programming language It has efficient high-level data structures and a simple but effective approach to objectoriented programming Python elegant syntax and dynamic typing";
       String str = "programming Python elegant syntax and dynamic typing";

//        String[] s1 = s.split(" ");
//        String[] s2 = str.split(" ");
//        List<String> strings = Arrays.asList(s2);
//        List<String> collect = Arrays.stream(s1).filter(o -> !strings.contains(o)).collect(Collectors.toList());

        String se = s.replaceAll(str, "");

        System.out.println(se);


    }


        /**  1. You are given the following unordered list of source and destination airports for a set of routes.
         * Find the path though the airports and output.

         Input:
         SFO → JFK
         PER → SYD
         SYD → SF
         JFK → LHR
         HKG → SNG
         SNG → HND

         OutPut:
         PER → SYD → SFO → JFK → LHR

         HKG → SNG → HND
         */



        private static void findPathRec(Map<String, String> routes, String src, String dest){

        System.out.println(src);
        if(routes.get(src) != dest){
            findPathRec(routes, routes.get(src), dest);
        }else {
            System.out.println(dest);

        }


    }

        private static List<String> findPath(Map<String, String> routes, String src, String dest){

        List<String> path = new ArrayList<String>();

        path.add(src);
        for(int i =0 ; i<routes.size(); i++ ){

            if(routes.get(src).equals(dest)){

                path.add(routes.get(src));
                break;
            }else {

                path.add(routes.get(src));
                src = routes.get(src);
            }
        }

        return path;
    }
}
