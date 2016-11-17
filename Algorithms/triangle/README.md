# Triangle
## Example
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
```
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
```
The minimum path sum from top to bottom is `11` `(i.e., 2 + 3 + 5 + 1 = 11)`.

# Solution
- Dynamic Programming
- Create a 2-dimensional array: `dp[i][j]` -> minimum path value from `0,0` to `i, j`
- From top to buttom
 - Initialize tow sides(left & right)
 - `dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j)`
- From buttom to top
 - Initialize the buttom side
 - `dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j)`
  
