# Majority Number
## Example
Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.
`You may assume that the array is non-empty and the majority number always exist in the array.`

e.g. Given `[1, 1, 1, 1, 2, 2, 2]`, return `1`

Solution
- Solution 1
 - HashMap to record the appearance of each number
- Solution 2
 - Count the appearance of the same number: `same number, + 1; different number, - 1`
