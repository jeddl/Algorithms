# Remove Nth Node From End Of List
## Example
Given a linked list, remove the Nth node from the end of list and return its head.

e.g. Given linked list: `1->2->3->4->5->null`, and `n = 2`.
After removing the second node from the end, the linked list becomes `1->2->3->5->null`.


## Solution
- Move the original node head to Nth nodes from start
- Create another list which is Nth nodes ahead of the current head node
- When head reaches the end, the new node locates at the Nth node from end of the list
