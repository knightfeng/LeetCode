/**
 * Given a binary tree, flatten it to a linked list in-place.
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
    public void flatten(TreeNode root) {
        
        if(root == null) return;
        
        if(root.right != null) {
            flatten(root.right);            
        }        
        
        if(root.left != null) {
            flatten(root.left);
            
            TreeNode tempRight = root.right;
            
            root.right = root.left;
            root.left = null;
            TreeNode curr = root;
            
            while(curr.right != null) {
                curr = curr.right;
            }
            
            curr.right = tempRight;
        }
        

       
        
    }
}


//Better Solution
private TreeNode prev = null;

public void flatten(TreeNode root) {
    if (root == null)
        return;
    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
}