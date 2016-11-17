/**
 * 
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
    public ListNode addLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode newNode = dummy;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            newNode.next = new ListNode(sum % 10);
            carry = sum / 10;
            newNode = newNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            newNode.next = new ListNode(l1.val + carry);
            carry = (l1.val + carry) / 10;
            newNode = newNode.next;
            l1 = l1.next;
        }
        while(l2 != null) {
            newNode.next = new ListNode(l2.val + carry);
            carry = (l2.val + carry) / 10;
            newNode = newNode.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            newNode.next = new ListNode(carry);    
        }
        return dummy.next;
    }
}