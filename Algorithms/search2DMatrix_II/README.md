# Search A 2D Matrix II
## Example
Give a 2D m x n matrix, which has following features:
 - Integers in each row are sorted from left to right.
 - Integers in each column are sorted from up to bottom.
 - No duplicate integers in each row or column.

```
[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]
```

return the occurrence of the target number. In this case, if the target number is 3, then return `2`.

## Solution 1
 - Loop m x n, put the number in a HashMap and search the HashMap
 - O(m x n) time
 
## Solution 2
 - Search the matrix from corner (either top right or bottom left; need to make sure one dimension is max)
 - If from top right
  - if `matrix[i][j] < target`, then move down; 
  - if `matrix[i][j] > target`, then move left;
  - if `matrix[i][j] == target`, then `count++` and move down and left
 - O(m + n) time
