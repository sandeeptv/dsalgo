package com.dsalgo.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MatchingParanthesis {

    public static boolean isValid(String s){

        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('{','}');
        brackets.put('[',']');
        brackets.put('(',')');

        Stack stack = new Stack();
        for(int i=0;i<s.length(); i++){
            if(brackets.get(s.charAt(i)) !=null){
                stack.push(s.charAt(i));
            }else {
                if(stack.size() == 0){
                    return false;
                }
                if(!brackets.get(stack.pop()).equals(s.charAt(i))){
                    return false;
                }

            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
}
