# Minimum Path Sum
## Example
Give a m X n grid, filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
```
[1, 2, 3, 4]
[3, 4, 5, 6]
[5, 6, 7, 8]
```
Return 
`24` because the min is `1 + 2 + 3 + 4 + 6 + 8 = 24`

## Solution
 - Dynamic Programming
 - `sum[i][j]` is the min sum of `sum[i - 1][j] || sum[i][j - 1]` `+` `grid[i][j]` (e.g. grid[1][1] = 4, sum[1][0] = `1 + 2` = 3, sum[0][1] = `1 + 3` = 4, so sum[1][1] = `3 + 4` = 7)
 - Initiate `sum[i][0]` and `sum[0][j]`
 - Loop from top left to bottom right
