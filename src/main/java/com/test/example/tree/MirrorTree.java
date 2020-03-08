package com.test.example.tree;

import com.test.example.other.Bnode;

import java.util.Deque;
import java.util.LinkedList;

public class MirrorTree {


    //to mirror a binary tree
    static Bnode mirror(Bnode root){

        if(root==null)
            return root;

        Bnode left = mirror(root.getLeft());
        Bnode right = mirror(root.getRight());

        root.setLeft(right);
        root.setRight(left);

        return  root;

    }


    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        final Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
}
