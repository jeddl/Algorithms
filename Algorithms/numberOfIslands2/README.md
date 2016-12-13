# Trapping Rain Water II
## Example
Given `n x m` non-negative integers representing an elevation map 2d where the area of each cell is `1 x 1`, compute how much water it is able to trap after raining.

Given `5*4` matrix
```
[12,13,0,12]
[13,4,13,12]
[13,8,10,12]
[12,13,12,12]
[13,13,13,13]
```
return `14`.

## Solution
- Similar to Number of Islands(using 2 pointers)
- Narrow down the area by checking bars' heights on 4 positions(up, down, left, right)
- The lower one always determines the amount of water that could be contained
