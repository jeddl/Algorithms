# Triangle Count
## Example
Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?

e.g. 

Given array `S = [3,4,6,7]`, return `3`. They are:
```
[3,4,6]
[3,6,7]
[4,6,7]
```

## Solution
- 2 pointers
- Similar to `2 Sum II` as the target number here is dynamic
 - Loop the array from the end as the target number in `2 Sum II`
