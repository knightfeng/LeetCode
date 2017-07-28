/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
 * adding up all the values along the path equals the given sum.
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, sum, 0);
    }
    
    public boolean hasPathSum(TreeNode root, int sum, int curr) {
        if(root == null) return false;
        curr += root.val;            
        if(root.left == null && root.right == null){
            if(sum == curr) return true;
        } 
        
        return hasPathSum(root.left, sum, curr) || hasPathSum(root.right, sum, curr);            
    }
    

}