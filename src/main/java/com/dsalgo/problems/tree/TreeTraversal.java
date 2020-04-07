package com.dsalgo.problems.tree;

import com.dsalgo.problems.other.Bnode;

import java.util.Stack;

public class TreeTraversal {


    public static void preOrderTraversal(Bnode root){
        if(root == null){
            return;
        }
        System.out.println(root.getVal());
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    public static void preOrderTraversalIt(Bnode root){
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

    public static void inOrderTraversal(Bnode root){
        if(root == null){
            return;
        }

        inOrderTraversal(root.getLeft());
        System.out.println(root.getVal());
        inOrderTraversal(root.getRight());
    }


    public static void inOrderTraversalIt(Bnode root){

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


    public static void postorderTraversal(Bnode root){
        if( root == null ){
            return;
        }
        postorderTraversal( root.getLeft() );
        postorderTraversal( root.getRight() );
        System.out.println(root.getVal());
    }

    public static void postorderTraversalIt(Bnode root) {
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
}
