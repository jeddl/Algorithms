# Identical Binary Tree
## Example
Identical:
```
    1             1
   / \           / \
  2   2   and   2   2
 /             /
4             4
```

Not identical:
```
    1             1
   / \           / \
  2   3   and   2   3
 /               \
4                 4
```

## Solution
Recursion

Two scenarios: 
- 1. node A == null and node B == null, which returns true
- 2. node A != null and node B != null
 - `A.value == B.value && A.left, B.left are identical && A.right, B.right are identical`, which returns true
