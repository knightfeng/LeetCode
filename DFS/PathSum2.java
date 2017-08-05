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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> listOfList = new ArrayList<List<Integer>>();
       
        pathSum(root, listOfList, new ArrayList<Integer>(), 0, sum, 0);        
        return listOfList;
    }
    
    public void pathSum(TreeNode root, List<List<Integer>> listOfList, List<Integer> path, int sum, int goal) {
        if(root == null) return;
        
        path.add(root.val);        
        sum += root.val;        
        
        if(root.left == null && root.right == null && sum == goal) {
           listOfList.add(path);                
        }
        
        if(root.left != null) {
            List<Integer> listLeft = new ArrayList<Integer>();
            listLeft.addAll(path);
            pathSum(root.left, listOfList, listLeft, sum, goal, depth+1);
        }
        
        if(root.right != null) {
            List<Integer> listRight = new ArrayList<Integer>();
            listRight.addAll(path);
            pathSum(root.right, listOfList, listRight, sum, goal, depth+1);
        }

        
    }
}



public List<List<Integer>> pathSum(TreeNode root, int sum){
	List<List<Integer>> result  = new LinkedList<List<Integer>>();
	List<Integer> currentResult  = new LinkedList<Integer>();
	pathSum(root,sum,currentResult,result);
	return result;
}

public void pathSum(TreeNode root, int sum, List<Integer> currentResult,
		List<List<Integer>> result) {

	if (root == null)
		return;
	currentResult.add(new Integer(root.val));
	if (root.left == null && root.right == null && sum == root.val) {
		result.add(new LinkedList(currentResult));
		currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
		return;
	} else {
		pathSum(root.left, sum - root.val, currentResult, result);
		pathSum(root.right, sum - root.val, currentResult, result);
    }
    
    //When the path is invalid.
	currentResult.remove(currentResult.size() - 1);
}