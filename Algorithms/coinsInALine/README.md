# Coins in A Line
## Example
There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left. The player who take the last coin wins.
Could you please decide the first play will win or lose?

`n = 1`, return `true`.

`n = 2`, return `true`.

`n = 3`, return `false`.

`n = 4`, return `true`.

`n = 5`, return `true`.


## Solution
- 1) dp[i]: If the current player will win when `i` coins left
 - `dp[i] = !dp[i - 1] || !dp[i - 2]` (Only true when EITHER the opponent takes 1 OR 2 will lose)
- 2) f[i]: If the first players will win when `i` coins left
 - `f[i] = (f[i - 2] && f[i - 3]) || (f[i - 3] && f[i - 4])` (Only true when the first player takes either 1 or 2, and in each circumstances no matter 
 how many coins are taken, the opponent loses)
- 3) Trick
