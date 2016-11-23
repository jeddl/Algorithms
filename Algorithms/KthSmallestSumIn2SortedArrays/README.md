# Kth Smallest Sum In 2 Sorted Arrays
## Example
Given two integer arrays sorted in ascending order and an integer k. Define sum = a + b, where a is an element from the first array and b is an element from the second one. Find the kth smallest sum out of all possible sums.

e.g.

Given `[1, 7, 11]` and `[2, 4, 6]`.

For `k = 3`, return `7`.

For `k = 4`, return `9`.

For `k = 8`, return `15`.

## Solution
- Heap
- New datatype which contains two numbers from different arrays and their sum.
- Keep tracking visited datatype pairs hash[][] records 
