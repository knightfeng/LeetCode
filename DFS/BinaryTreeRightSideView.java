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
    public List<Integer> rightSideView(TreeNode root) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        rightSideView(root, map, 0);
        List<Integer> list = new ArrayList<Integer>(map.values());
        return list;                
    }
    
    public void rightSideView(TreeNode root, HashMap<Integer, Integer> depths, Integer depth) {
        if(root == null) return;
        
        //Do
        if(!depths.containsKey(depth)){
            depths.put(depth, root.val);
        }
        
        if(root.right != null) {
            rightSideView(root.right, depths, depth+1); 
        }
        
        if(root.left != null) {
            rightSideView(root.left, depths, depth+1);
        }
    }
}



public class BetterSolution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}