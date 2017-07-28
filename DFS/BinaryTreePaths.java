/**
 * Given a binary tree, return all root-to-leaf paths.
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<String>();
        StringBuilder sb = new StringBuilder("");
        binaryTreePaths(root, list, sb);
        return list;                 
    }
    
    public void binaryTreePaths(TreeNode root, List<String> list, StringBuilder str) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            String result = str.append(root.val).toString();
            list.add(result);
        } else {
            String temp = str.append(root.val+"->").toString();
            StringBuilder left = new StringBuilder(temp);
            StringBuilder right = new StringBuilder(temp);
            binaryTreePaths(root.left, list, left);
            binaryTreePaths(root.right, list, right);            
        }
    }
}