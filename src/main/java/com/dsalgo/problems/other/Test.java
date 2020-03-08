package com.dsalgo.problems.other;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
	
	static void preOrderTraversal(Bnode root){
		if(root == null){
			return;
		}
		System.out.println(root.getVal());
		preOrderTraversal(root.getLeft());
		preOrderTraversal(root.getRight());
	}

	static void preOrderTraversalIt(Bnode root){
		if(root == null){
			return;
		}
		System.out.println("---------preOrderTraversalIT----------");

		Stack<Bnode> stack = new Stack<>();
		stack.add(root);
		while(!stack.isEmpty()){
			Bnode node = stack.pop();
			System.out.println(node.getVal());

			if(node.getRight()!=null){
				stack.push(node.getRight());
			}
			if(node.getLeft()!=null){
				stack.push(node.getLeft());
			}
		}

	}
	
	static void inOrderTraversal(Bnode root){
		if(root == null){
			return;
		}

		inOrderTraversal(root.getLeft());
		System.out.println(root.getVal());
		inOrderTraversal(root.getRight());
	}


	static void inOrderTraversalIt(Bnode root){

		if(root == null){
			return;
		}
		System.out.println("---------inOrderTraversalIT----------");

		Stack<Bnode> stack = new Stack<>();

		Bnode curr = root;


		while(curr!=null || !stack.isEmpty()){

			while(curr!=null){
				stack.push(curr);
				curr = curr.getLeft();
			}
			Bnode bnode = stack.pop();
			System.out.println(bnode.getVal());

			curr = bnode.getRight();
		}
	}

	public boolean isValidBST(Bnode root) {
		if (root == null) return true;
		Stack<Bnode> stack = new Stack<>();
		Bnode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.getLeft();
			}
			root = stack.pop();
			if(pre != null && root.getVal() <= pre.getVal()) return false;
			pre = root;
			root = root.getRight();
		}
		return true;
	}

	static void postorderTraversal( Bnode root ){
		if( root == null ){
			return;
		}
		postorderTraversal( root.getLeft() );
		postorderTraversal( root.getRight() );
		System.out.println(root.getVal());
	}

	static void postorderTraversalIt( Bnode root ) {
		if (root == null) {
			return;
		}
		System.out.println("---------postOrderTraversalIT----------");

		Stack<Bnode> stack = new Stack<>();

		Stack<Integer> revStack = new Stack<>();


		stack.push(root);
		while(!stack.isEmpty()){


			Bnode bnode = stack.pop();
			revStack.push(bnode.getVal());
			if(bnode.getLeft()!=null){
				stack.push(bnode.getLeft());
			}

			if(bnode.getRight()!=null){
				stack.push(bnode.getRight());
			}

		}
		while (!revStack.isEmpty()){
			System.out.println(revStack.pop());
		}
	}

	static void bfs(Bnode root){
		Queue<Bnode> queue = new LinkedList<Bnode>();
		queue.add(root);
		while(!queue.isEmpty()){
			Bnode currnode = queue.poll();
			System.out.println(currnode.getVal());
			queue.add(currnode.getLeft());
			queue.add(currnode.getRight());
		}
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
	static boolean isBST(Bnode root) {
		vaildate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return true; //preOrderTraversalBST(root);
		
}
	static boolean preOrderTraversalBST(Bnode root){
		if(root == null){
			return true;
		}
		preOrderTraversalBST(root.getLeft());
		preOrderTraversalBST(root.getRight());
	
		System.out.println(root.getVal());
		if(root.getLeft().getVal()<root.getVal()&&root.getRight().getVal()>root.getVal()){
			return true;
		}
		
		return false;
	}
	
	
	static boolean vaildate(Bnode root,int min,int max){
		if(root==null){

		return true;
	}
		if(root.getVal()>min&&root.getVal()<max
				&& vaildate(root.getLeft(),min,root.getVal())
				&& vaildate(root.getRight(),root.getVal(),max)){
			return true;
		}
		
		return false;
	}
	static int count=0;

static int depth(Bnode root) {
	if(root == null)
        return 0;
	System.out.println("root "+root.getVal());
 
    return 1+Math.max(depth(root.getLeft()), depth(root.getRight()));
}



private static void zigZagTraversal(Bnode root) {
	int leftToRight=1;
	Bnode temp;
	Stack<Bnode> currentLevel=new Stack<Bnode>();
	Stack<Bnode> nextLevel=new Stack<Bnode>();
	
	System.out.println("Zig Zag Traversal");
	currentLevel.push(root);
	while (!currentLevel.isEmpty()) {
		temp = currentLevel.pop();
		if(temp!=null)
		{
			System.out.println(temp.getVal());
			if(leftToRight==1)
			{
				if (temp.getLeft() != null)
					nextLevel.push(temp.getLeft());
				if (temp.getRight() != null)
					nextLevel.push(temp.getRight());
			}
			else
			{
				if (temp.getRight() != null)
					nextLevel.push(temp.getRight());
				if (temp.getLeft() != null)
					nextLevel.push(temp.getLeft());
			}
			
		}
		if(currentLevel.isEmpty())
		{
			leftToRight=1-leftToRight;
			while(!nextLevel.isEmpty())
			{
				currentLevel.push(nextLevel.pop());
			}
		}
		
		
	}
}




}