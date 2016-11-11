# 3 Sum Closest
## Example
Given an array `S` of `n` integers, find three integers in `S` such that the sum is closest to a given number, target. Return the sum of the three integers.

NOTE: You can just return only one solution.

e.g. 
Given array `S = [-1 2 1 -4]`, and `target = 1`. The sum that is closest to the target is `2` because `(-1 + 2 + 1 = 2)`.

## Solution
- Sort the array
- 2 pointers + 1 pointer
- Since only 1 answer is needed, do not consider duplicates in the given array
