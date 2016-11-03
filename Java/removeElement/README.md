# Remove Element
## Exmaple
Given an array and a value, remove all occurrences of that value in place and return the new length.

The order of elements can be changed, and the elements after the new length don't matter.

e.g. 
Given an array `[0,4,4,0,0,2,4,4]`, value = `4`

return `4` and front four elements of the array is `[0,0,0,2]`

## Solution
- Two pointers: one at first index, and the other at last index
- NOTE the order of elements in the array could be changed
