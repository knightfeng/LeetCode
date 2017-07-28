/**
 * Definition for a binary tree node.
 * 
 * 
 * 
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. 
 * Otherwise, the NOT null node will be used as the node of new tree.
 */

public class MergeTwoBinaryTrees {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null)
            return null;

        if (t1 != null && t2 != null) {
            TreeNode mergedNode = new TreeNode(t1.val + t2.val);
            mergedNode.left = mergeTrees(t1.left, t2.left);
            mergedNode.right = mergeTrees(t1.right, t2.right);
            return mergedNode;
        }

        if (t1 == null && t2 != null) {
            TreeNode mergedNode = new TreeNode(t2.val);
            mergedNode.left = mergeTrees(null, t2.left);
            mergedNode.right = mergeTrees(null, t2.right);
            return mergedNode;
        }

        if (t1 != null && t2 == null) {
            TreeNode mergedNode = new TreeNode(t1.val);
            mergedNode.left = mergeTrees(t1.left, null);
            mergedNode.right = mergeTrees(t1.right, null);
            return mergedNode;
        }

        return null;

    }
}