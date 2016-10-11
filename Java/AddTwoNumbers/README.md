# Add Two Numbers
## Example
Given `8->1->9 + 2->2->1`, which is 918 + 122

Return `0->4->0->1`, which is 1040.

## How to solve
- Consider `carry` while doing the calculation
- Build two new Linked List by
```
ListNode dummy = new ListNode(0);
ListNode newNode = dummy;
```
- Use `newNode.next = new ListNode(...)`to build the new list
- Loop every element in list1 and list2. If elements in list1 > list2, then remember to loop the rest of them
- Always remeber there is `carry` which might not be `0`
