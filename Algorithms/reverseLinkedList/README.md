# Reverse Linked List
## Example
Given a Linked List, reverse the Linked List from position m to n.

e.g. Given `1 -> 2 -> 3 -> 4 -> 5` and `m = 2`, `n = 4`
Return `1 -> 4 -> 3 -> 2 -> 5`

## Tip
 - Create 5 nodes: dummy, prevmNode(which is the node before m), mNode, nNode(start from m, loop to n) and postnNode(next node of node n)
 - Note that should always start from one node before node m.
 - At last, connect the reversed Linked List
 
 ```java
        prevmNode.next = nNode;
        mNode.next = postnNode;
        return dummy.next;
 ```
