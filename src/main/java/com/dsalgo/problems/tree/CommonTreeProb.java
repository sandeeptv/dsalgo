package com.dsalgo.problems.tree;

import com.dsalgo.problems.other.Bnode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CommonTreeProb {



    public static boolean isBST(Bnode root) {
        boolean vaildate = vaildate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return vaildate;

    }
    static boolean vaildate(Bnode root, int min, int max){
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


    // Validate BST Iterative
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

    // Tree BST breadth first search bfs
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

    //depth of a tree
    public static int depth(Bnode root) {
        if(root == null)
            return 0;
        System.out.println("root "+root.getVal());

        return 1+Math.max(depth(root.getLeft()), depth(root.getRight()));
    }
}
