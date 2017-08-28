/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        
        HashMap<Integer, TreeLinkNode> map = new HashMap<Integer, TreeLinkNode>();
        connect(root, map, 0);        
        
    }
    
    public void connect(TreeLinkNode root, HashMap<Integer, TreeLinkNode> map, Integer d) {
        
        if(root == null) return;
        
        connect(root.right, map, d+1);
        connect(root.left, map, d+1);
        
        if(map.containsKey(d)) {
            root.next = map.get(d);
            map.remove(d);
        } else {
            root.next = null;            
        }
        
        map.put(d, root);
        
    }
}