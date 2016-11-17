public class Solution {
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
    
    private Comparator<ListNode> NodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode first, ListNode second) {
            if (first == null) {
                return 1;
            }
            if (second == null) {
                return -1;
            }
            return first.val - second.val;
        }
    };
     
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0) {
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), NodeComparator);
        
        for (ListNode i : lists) {
            if (i != null) {
                heap.add(i);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = tail.next;
            if (head.next != null) {
                heap.add(head.next);
            }
        }
        
        return dummy.next;
    }
}
