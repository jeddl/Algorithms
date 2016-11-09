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
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode tempNode = headA;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = headB;
        ListNode result = listCycle(headA);
        tempNode.next = null;
        
        return result;
    }
    
    private ListNode listCycle(ListNode headA) {
        ListNode slow = headA, fast = headA.next;
        
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = headA;
        fast = fast.next;
        
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return fast;
    }
}