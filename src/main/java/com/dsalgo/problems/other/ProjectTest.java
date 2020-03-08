package com.dsalgo.problems.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectTest {

	
	public static void main(String[] args) {
       Map<String, Integer> one = new HashMap<String, Integer>();
       Map<String, Integer> two = new HashMap<String, Integer>();
       	List<String> list = new ArrayList<String>();
       int ace =1;
       one.put("one", ace);
       one.put("thre", 3);

       
       two.put("ssss", one.get("one"));
       two.put("two", 2);
       
       System.out.println(one);
       System.out.println(two);

    }
}
