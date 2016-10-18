# Merge K Sorted Lists
## Example
Given
```
[
  -1 -> 2 -> 3,
  null,
  1 -> 4
]
```

Return
`-1 -> 1 -> 2 -> 3 -> 4 -> null`

## Solution
 - Use `PriorityQueue` as a `heap`, create a `Comparator`
 - In this heap, the lists are sorted as the acsending order of the first node value
 - Put lists in the heap, pull the smallest node out to create the new list; push the rest of the list back in the heap
 - After pushing back, heap will sort the lists again according to the values of the current first nodes
