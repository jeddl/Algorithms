# Linked List Cycle
## Example
Given a linked list, determine if it has a cycle in it.

# Tip
 - Use two pointers: fast and slow, where:
 
 ```java
 Node fast = node.next;
 Node slow = node;
 while (fast != slow) {
     // Do Something...
     fast = fast.next.next;
     slow = slow.next;
 }
 ```
 
 - If it does not have a cycle, then slow will be the middle of the linked list while fast goes to the end.
 
