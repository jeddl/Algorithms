# Coins in A Line 2
## Example
There are n coins with different value in a line. Two players take turns to take one or two coins from left side until there are no more coins left. The player who take the coins with the most value wins.

Could you please decide the first player will win or lose?

Given values array `A = [1,2,2]`, return `true`.

Given `A = [1,2,4]`, return `false`.

## Solution
- 1) `dp[i] = Math.max(Math.min(dp[i - 2], dp[i - 3]) + values[n - i], Math.min(dp[i - 3], dp[i - 4]) + values[n - i] + values[n - i + 1])`
 - dp[i]: Max value that the first player can take when `i` coins left. 
- 2) `dp[i] = Math.max(sum[i] - dp[i - 1], sum[i] - dp[i - 2])`
 - dp[i]: Max value that current player can take when `i` coins left
