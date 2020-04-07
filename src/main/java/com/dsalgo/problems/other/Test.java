package com.dsalgo.problems.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import static com.dsalgo.problems.tree.CommonTreeProb.depth;
import static com.dsalgo.problems.tree.CommonTreeProb.isBST;
import static com.dsalgo.problems.tree.TreeTraversal.inOrderTraversal;
import static com.dsalgo.problems.tree.TreeTraversal.inOrderTraversalIt;
import static com.dsalgo.problems.tree.TreeTraversal.postorderTraversal;
import static com.dsalgo.problems.tree.TreeTraversal.postorderTraversalIt;
import static com.dsalgo.problems.tree.TreeTraversal.preOrderTraversal;
import static com.dsalgo.problems.tree.TreeTraversal.preOrderTraversalIt;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> linklist = new LinkedList<Integer>();
		linklist.add(2);
		linklist.get(0);
		MyLinkedList<Integer> am = new MyLinkedList<Integer>();
		am.addFirst(1);
		am.add(2);
		am.add(3);
		am.add(4);
		am.add(5);
		am.add(6);
		//am.remove(1);
		//am.removeByIndex(4);
		Node head = am.getHead();

		LinkedListProb linkedListProb = new LinkedListProb();
		Node revHead = linkedListProb.reverseLinkedList(head);
		System.out.println(revHead.getValue());
		
		Bnode aBnode = new Bnode(100, null, null);
		Bnode left = new Bnode(50,null,null); 
		Bnode right = new Bnode(150,null,null); 
		aBnode.setLeft(left);
		aBnode.setRight(right);
		
		Bnode one = new Bnode(25,null,null); 
		Bnode two = new Bnode(75,null,null); 
		left.setLeft(one);
		left.setRight(two);
		
		Bnode three = new Bnode(125,null,null); 
		Bnode four = new Bnode(175,null,null); 
		right.setLeft(three);
		right.setRight(four);
		
		//Bnode five = new Bnode(110,null,null); 
		//three.setLeft(five);
		depth(aBnode);
		isBST(aBnode);
		System.out.println("---------preOrderTraversal----------");

		preOrderTraversal(aBnode);

		preOrderTraversalIt(aBnode);

		System.out.println("---------inOrderTraversal----------");

		inOrderTraversal(aBnode);
		inOrderTraversalIt(aBnode);

		System.out.println("---------postOrderTraversal----------");

		postorderTraversal(aBnode);
		postorderTraversalIt(aBnode);
		//Test.push("abc");
	//Test.push("int");
	
	//System.out.println(Test.pop());
	
	/*ForkJoinPool aFp = new ForkJoinPool(16);
	int[] arr= new int[6000];
	for(int i=0;i<6000;i++){
		arr[i]=i*3;
	}
	int sum = aFp.invoke(new Sum(arr));
	System.out.println("summm "+ sum);
	System.out.println("thread count "+aFp.getActiveThreadCount());
System.out.println(" paralleleism "+aFp.getParallelism());
System.out.println(" pool size "+aFp.getPoolSize());
System.out.println(" steal count size "+aFp.getStealCount());*/

	}



 static List<String> arrr = new ArrayList<String>();
	
	public static void push(String value){
		arrr.add(value);
	}
	public static String pop(){
		arrr.size();
		return arrr.get(arrr.size()-1);
	}
	
	static boolean flag ;


	
	








}