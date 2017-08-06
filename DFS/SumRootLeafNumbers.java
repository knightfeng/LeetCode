
/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        return sumNumbers(root, sb);

    }

    public int sumNumbers(TreeNode root, StringBuilder sb) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            int result = Integer.parseInt(sb.append(root.val).toString());
            return result;
        }

        if (root.left == null) {
            sb.append(root.val);
            return sumNumbers(root.right, sb);
        }

        if (root.right == null) {
            sb.append(root.val);
            return sumNumbers(root.left, sb);
        }

        StringBuilder leftSB = new StringBuilder(sb.toString());
        leftSB.append(root.val);

        StringBuilder rightSB = new StringBuilder(sb.toString());
        rightSB.append(root.val);

        return sumNumbers(root.left, leftSB) + sumNumbers(root.right, rightSB);
    }
}


// Using int is faster than using StringBuilder.
public class BetterSolution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode n, int s) {
        if (n == null)
            return 0;
        if (n.right == null && n.left == null)
            return s * 10 + n.val;
        return sum(n.left, s * 10 + n.val) + sum(n.right, s * 10 + n.val);
    }
}