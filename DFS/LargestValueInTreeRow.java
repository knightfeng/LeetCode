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
    public List<Integer> largestValues(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        largestValues(root, map, 0);
        ArrayList<Integer> result = new ArrayList<Integer>(map.values());
        return result;
        
    }
    
    public void largestValues(TreeNode root, HashMap<Integer, Integer> map, Integer d) {
        if(root == null) return;
        
        if(!map.containsKey(d)) {
            map.put(d, root.val);
        } else if(map.get(d) < root.val) {
            map.put(d, root.val);
        }
        
        largestValues(root.left, map, d+1);
        largestValues(root.right, map, d+1);
    }
}