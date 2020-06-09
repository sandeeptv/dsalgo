package com.dsalgo.problems.tree;

import java.util.Stack;

public class PreorderToBst {

    /**
     * Return the root node of a binary search tree that matches the given preorder traversal.
     *
     * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
     *
     * It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.
     *
     * Example 1:
     *
     * Input: [8,5,1,7,10,12]
     * Output: [8,5,10,1,7,null,12]
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {

        if(preorder==null || preorder.length == 0 ){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i <preorder.length ; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (preorder[i] < stack.peek().val) {
                stack.peek().left = node;
            } else {
                TreeNode parent = stack.peek();
                while (!stack.isEmpty() && preorder[i] > stack.peek().val) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);

        }
return root;
    }

    int nodeIdx;
    public TreeNode bstFromPreorderRec(int[] preorder) {
        if(preorder == null) {
            return null;
        }
        nodeIdx = 0;
        return bstHelper(preorder, Integer.MIN_VALUE , Integer.MAX_VALUE);
    }
    private TreeNode bstHelper(int[] preorder, int start, int end) {
        if(nodeIdx == preorder.length || preorder[nodeIdx]<start || preorder[nodeIdx]>end) {
            return null;
        }
        int val = preorder[nodeIdx++];
        TreeNode node = new TreeNode(val);
        node.left = bstHelper(preorder, start, val);
        node.right = bstHelper(preorder, val, end);
        return node;
    }

}
