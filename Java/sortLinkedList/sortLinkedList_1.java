/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    public ListNode sortList(ListNode head) {  
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMid(head);
        ListNode sortRight = sortList(mid.next);
        mid.next = null;
        ListNode sortLeft = sortList(head);
        
        return merge(sortLeft, sortRight);
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        
        while (left != null) {
            tail.next = left;
            left = left.next;
            tail = tail.next;
        }
        
        while (right != null) {
            tail.next = right;
            right = right.next;
            tail = tail.next;
        }
        
        return dummy.next;
    }
}