package com.dsalgo.problems.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ShuffleCards {

    public static void main(String[] args) {


        ShuffleCards sol = new ShuffleCards();
        Map<Integer,Card > deck  = sol.buildDeck();
        sol.shuffle(deck, 10);
        Map<Integer,Integer> count = new HashMap<>();
        deck.forEach((k,v) ->
                    count.put(v.number , count.getOrDefault(v.number,0)+1));

        boolean found = count.values().stream().anyMatch(v -> v < 4);
        System.out.println(found);

//        deck.forEach(d -> System.out.println(d.shape + " : " + d.number));

    }

    private  Map<Integer,Card > buildDeck(){

        List<String> shapes = Arrays.asList("Diamond", "clubs", "spade","heart");
        Map<Integer,Card > deck = new HashMap<>(52);
        AtomicInteger count= new AtomicInteger();
        shapes.forEach(s->{

            for(int i=1;i<=13;i++){

                deck.put(count.getAndIncrement(),new Card(i, s));
            }
        });



        return deck;
    }

    private Map<Integer,Card >  shuffle( Map<Integer,Card > deck, int n){

        Random rand = new Random();
        for(int i=0;i<n;i++){


            int src = rand.nextInt(52);
            int dest = rand.nextInt(52);
            System.out.println(src + ":" + dest);

            System.out.println(deck.get(src) + ":" + deck.get(dest));
            Card temp = deck.get(src);
            deck.put(src,deck.get(dest));
            deck.put(dest,temp);
        }
        System.out.println(deck.size());
        deck.forEach((k,v) -> System.out.println(v.shape + " : " + v.number));
        return deck;
    }

     class Card{

        int number;
        String shape;

        public Card(int number, String shape){
            this.number = number;
            this.shape = shape;
        }

        public String toString(){
            return this.shape + " : " + this.number;
        }
    }
}
