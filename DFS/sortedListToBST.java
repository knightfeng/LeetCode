public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;        
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode curr = head;
        
        while(curr != null) {
            list.add(curr.val);
            len++;
            curr = curr.next;
        }
        
        return convertToNode(list ,0, len-1);
    }
    
    public TreeNode convertToNode(ArrayList list, int start, int end) {
        if(start > end) return null;
        int mid = ((end-start) / 2) + start;
        int val = Integer.parseInt(list.get(mid).toString());
        TreeNode midNode = new TreeNode(val);
        
        midNode.left = convertToNode(list, start, mid-1);
        midNode.right = convertToNode(list, mid+1, end);
        
        return midNode;
        
    }
    
}


public class BetterSolution {
public TreeNode sortedListToBST(ListNode head) {
    if(head==null) return null;
    return toBST(head,null);
}
public TreeNode toBST(ListNode head, ListNode tail){
    ListNode slow = head;
    ListNode fast = head;
    if(head==tail) return null;
    
    while(fast!=tail&&fast.next!=tail){
        fast = fast.next.next;
        slow = slow.next;
    }
    TreeNode thead = new TreeNode(slow.val);
    thead.left = toBST(head,slow);
    thead.right = toBST(slow.next,tail);
    return thead;
}
}
