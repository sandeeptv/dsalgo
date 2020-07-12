package com.dsalgo.problems.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Integer game you have n cards and a deck on table and an open Integer on table, you need to throw 1 Integer either of same value OR higher value first from your pack then deck.
 * first one to finish is winner. design this game
 */
public class CardGame {


    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        Map<Integer, Integer> deck = cardGame.buildDeck();
        System.out.println( deck.size());
         deck = cardGame.shuffle(deck, 5);


        Queue<Integer> deckQ = new LinkedList<>();
        deckQ.addAll(new HashSet<>(deck.values()));
        System.out.println( deckQ.size());
        Queue<Integer> player1 = cardGame.distribute(deckQ,5);
        System.out.println(player1.size() + " :" + deckQ.size());
        Queue<Integer> player2 = cardGame.distribute(deckQ, 5);
        System.out.println(player2.size() + " :" + deckQ.size());

        Integer draw = deckQ.poll();
        cardGame.play(draw, deckQ,player1,player2);
//        deck.forEach((k,v) -> System.out.println(k +":"+ v));
    }

public Map<Integer,Integer> buildDeck(){
     Map<Integer,Integer> deck = new HashMap<>();
    String [] shapes = new String[]{"diamond", "spade", "clubs", "hearts"};
    AtomicInteger count = new AtomicInteger();
    Arrays.stream(shapes).forEach(
            s -> {
                for(int i=0 ; i<13;i++){
                    deck.put(count.getAndIncrement(),i);
                }
            }
    );
    return deck;
}
public Map<Integer,Integer> shuffle( Map<Integer,Integer> deck, int times){
    List<Integer> sr = new ArrayList();
    Collections.shuffle(sr);

    Random random = new Random();
        for(int i=0 ; i<times ; i++){
            int src = random.nextInt(52);
            int dest = random.nextInt(52);
            Integer temp = deck.get(src);
            deck.put(src, deck.get(dest));
            deck.put(dest, temp);


        }
        return deck;

}
public void play(Integer intitialCard, Queue<Integer> deck, Queue<Integer> player1,  Queue<Integer> player2){

while(!deck.isEmpty()) {
    System.out.println("open card: " + intitialCard + " deck size: "+deck.size() + " player1: "+player1.peek() + " player2: "+player2.peek());

    if (player1.peek() >= intitialCard) {
        intitialCard = player1.poll();
    } else {
        player1.add(deck.poll());
    }
    if (player1.isEmpty()) {
        System.out.println("player1  wins");
        break;
    }

    if (player2.peek() >= intitialCard) {
        intitialCard = player2.poll();
    } else {
        if(deck.isEmpty()){
            System.out.println("no one  wins");
            break;
        }
        player2.add(deck.poll());
    }

    if (player2.isEmpty()) {
        System.out.println("player2  wins");
        break;
    }
}
    System.out.println("no one  wins");
}

public Integer draw(Map<Integer, Integer> deck){
        Random random = new Random();
    if(deck.entrySet().iterator().hasNext()){
        Map.Entry<Integer, Integer> next = deck.entrySet().iterator().next();

        return deck.remove(next.getKey());
    }
    return null;
}

public Queue<Integer> distribute(Queue<Integer> deck, int totalCards ){
    Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < totalCards; i++) {
        maxHeap.add(deck.poll());

    }
    return maxHeap;
}

}
//class Integer{
//
//    int number;
//    String shape;
//
//    public Integer(int number, String shape){
//        this.number = number;
//        this.shape = shape;
//    }
//
//    public String toString(){
//        return this.shape + " : " + this.number;
//    }
//}