/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(isBalanced(root, 1) != -1) return true;
        return false;
    }
    
    public int isBalanced(TreeNode root, int d) {
        if(root == null) return d-1;
        
        int left = isBalanced(root.left, d+1);
        int right = isBalanced(root.right, d+1);
        
        if(Math.abs(left - right) > 1) return -1;
        else return Math.max(left, right);
    }
}