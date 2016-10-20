# Subtree
## Example
You have two every large binary trees: T1 and T2. Determine if T2 is a subtree of T1.
```
       1                3
      / \              / 
T1 = 2   3      T2 =  4
        /
       4
```
T2 is a subtree of T1.

```
       1               3
      / \               \
T1 = 2   3       T2 =    4
        /
       4
```
T2 is not a subtree of T1

## Solution
- Recursion
- Note that
 - If `T2 == null`, `true`
 - If `T1 == null`, `false`
 - If T1 and T2 are identical, `true`
 - If T2 is a subtree of T1, `true` (Recursion)
- T1 and T2 are identical
 - T1 == null || T2 == null, `return T1 == T2`
 - `Are values of the two identical? true : false`
 - T1.left and T2.left are identical `&&` T1.right and T2.left are identical(Recursion)
