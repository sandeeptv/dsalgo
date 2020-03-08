package com.test.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    Node head;
    Node tail;
    int capacity = 0;
    private Map<Integer, Node> map;

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

    }

    public int get(int key) {
        Node node = map.get(key);
        if (null == node) {
            return -1;
        } else {
            int val = node.val;
            remove(node);
            moveToHead(node);
            return val;
        }

    }

    public void put(int key, int val) {
        Node node = map.get(key);
        if (null != node) {
            node.val = val;
            map.put(key, node);
            remove(node);
            moveToHead(node);
        } else {
            Node node1 = new Node(key, val);
            if (capacity == map.size()) {
                map.remove(tail.key);
                remove(tail);
            }
            map.put(key,node1);
            moveToHead(node1);
        }

    }

    private void remove(Node node) {

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void moveToHead(Node node) {

        if (head == null) {

            head = node;
            tail = node;
        }else {
            node.next = head;
            head.prev = node;
            head = node;
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );


        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
         cache.put(3, 3);    // evicts key 2
         System.out.println(cache.get(2));       // returns -1 (not found)
      cache.put(4, 4);    // evicts key 1
         System.out.println(cache.get(1));       // returns -1 (not found)
         System.out.println(cache.get(3));       // returns 3
         System.out.println(cache.get(4));



         //To use linked hashmap

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(3,.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > 3;
            }
        };
    }

}
