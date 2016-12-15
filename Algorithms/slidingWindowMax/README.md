# Sliding Window Maximum
## Example
Given an array of n integer with duplicate number, and a moving window(size k), move the window at each iteration from the start of the array, find the maximum number inside the window at each moving.

For array `[1, 2, 7, 7, 8]`, moving window size `k = 3`. return `[7, 7, 8]`

At first the window is at the start of the array like this
`[|1, 2, 7| ,7, 8]`, return the maximum `7`;

then the window moves one step forward.
`[1, |2, 7 ,7|, 8]`, return the maximum `7`;

then the window moves one step forward again.
`[1, 2, |7, 7, 8|]`, return the maximum `8`

`LintCode`


## Solution
- Use deque data structure
- Keep the data in descending order in the deque
- Only 3 elements allowed
