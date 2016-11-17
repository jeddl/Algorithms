public class Solution {
    /**
     * Definition for ListNode
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy; // NOTE!!!!

        for (int i = 1; i < m ; i++) {
            head = head.next;
        }

        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postnNode = nNode.next;

        for (int j = m; j < n; j++) {
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }

        premNode.next = nNode;
        mNode.next = postnNode;
        
        return dummy.next;
    }
}