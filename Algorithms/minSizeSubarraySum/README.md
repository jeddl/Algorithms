# Minimum Size Subarray Sum
## Example
Given an array of `n` positive integers and a positive integer `s`, find the minimal length of a subarray of which `sum ≥ s`. 
If there isn't one, return `-1` instead.

Given the array `[2,3,1,2,4,3]` and `s = 7`, the subarray `[4,3]` has the minimal length under the problem constraint.

## Solution
- 2 pointers towards the same direction
- Remember to delete the previous element at `left` while looping
- O(n)
