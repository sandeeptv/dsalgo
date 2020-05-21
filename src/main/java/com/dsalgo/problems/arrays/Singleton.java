package com.dsalgo.problems.arrays;

public class Singleton {

        private static Singleton instance = null;

        public String s;

        private Singleton()
        {
        }

        public static Singleton getInstance()
        {
            if (instance == null){
                synchronized (Singleton.class){
                    if (instance == null){
                        instance = new Singleton();
                    }
                }
            }


            return instance;
        }
    }
