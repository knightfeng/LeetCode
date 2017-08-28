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
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        findBottomLeftValue(root, list, 0);
        return list.getLast().intValue();
    }
    
    public void findBottomLeftValue(TreeNode root, LinkedList list, int d) {
        if(root == null) return;
        
        if(list.size() == d) {
            list.add(root.val);
        }
        
        findBottomLeftValue(root.left, list, d+1);
        findBottomLeftValue(root.right, list, d+1);        
    }
    
}
