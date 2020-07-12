package com.dsalgo.problems.other;

import java.util.Objects;

public class MyMap<K,V> {

    public static void main(String[] args) {
        MyMap<String, Integer> map = new MyMap<>();

        map.put("abc", 1);
        System.out.println(map.get("abc"));
        map.put("abc",2);
        System.out.println(map.get("abc"));
        map.put("def",45);
        map.put(null,null);
        System.out.println(map.get("def"));

    }

    Entry[] bucket = new Entry[1000];
    class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


        public V get(K key){
            Entry entry = bucket[getIndex(key)];
            if(entry==null){
                return null;
            }
            while(entry!=null){
                if(entry.key.equals(key)){
                    return (V) entry.value;
                }
                entry = entry.next;
            }
            return null;
        }

        public void put(K key, V value){
            int index = getIndex(key);
            Entry prev = null;
            Entry entry = bucket[index];
            if(entry==null){
                bucket[index] = new Entry(key,value,null);
                return;
            }
            while(entry!=null){
                if(entry.key.equals(key)){
                    entry.value = value;
                    return;
                }
                prev = entry;
                entry = entry.next;
            }

                prev.next = new Entry(key,value,null);

        }

        private int getIndex(K key){

            int hashCode = Objects.hashCode(key);
            System.out.println(hashCode);
            return hashCode % bucket.length;
        }

    }

