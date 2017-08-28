/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null) return null;
        
        int lenA = length(headA);        
        int lenB = length(headB);
        
        int diff = Math.max(lenA, lenB) - Math.min(lenA, lenB);
        
        ListNode currA = headA;
        ListNode currB = headB;
            
        if(lenA > lenB) {
            while(diff > 0) {
                currA = currA.next;
                diff--;
            }
        } else {
            while(diff > 0) {
                currB = currB.next;
                diff--;
            }
        }
        
        while(currA != null && currB != null) {
            if(currA == currB) return currA;
            currA = currA.next;
            currB = currB.next;
        }
        
        return null;
        
    }
    
    private int length(ListNode node) {
        ListNode curr = node;
        int len = 1;
        while(curr != null) {
            curr = curr.next;
            len++;
        }
        return len;
    }
}

