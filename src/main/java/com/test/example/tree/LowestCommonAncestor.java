package com.test.example.tree;

public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {

        //Find if both elements are the left tree or the right tree
        // if they both are not on the same side of the root node then return teh root
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestorBST(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestorBST(root.right, p , q);
        }else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null){
            return null;
        }
        if(left != null && right !=null ){
            return root;
        }
        return left == null ? right : left;
    }
}
