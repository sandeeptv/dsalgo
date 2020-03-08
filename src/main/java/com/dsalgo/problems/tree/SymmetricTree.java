package com.dsalgo.problems.tree;

import com.dsalgo.problems.other.Bnode;

import java.util.Stack;

public class SymmetricTree {


    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode n1 = stack.pop(), n2 = stack.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;
            stack.push(n1.left);
            stack.push(n2.right);
            stack.push(n1.right);
            stack.push(n2.left);
        }
        return true;
    }


//to check if  Left and Right subtrees are Mirror
//Checks if tree can be folded or not

    static	boolean isFoldable(Bnode node)
    {
        if (node == null)
            return true;

        return isFoldableUtil(node.getLeft(), node.getRight());
    }

    private static boolean isFoldableUtil(Bnode node1, Bnode node2) {
        if (node1 == null && node2 == null)
            return true;
        if ((node1 == null && node2 != null)
                || (node1 != null && node2 == null))
            return false;

        if (node1.getVal() != node2.getVal())
            return false;
        else
            return isFoldableUtil(node1.getLeft(), node2.getRight())
                    && isFoldableUtil(node1.getRight(), node2.getLeft());
    }
}
