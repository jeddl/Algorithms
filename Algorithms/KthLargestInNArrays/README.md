# Kth Largest In N Arrays
## Example
Find K-th largest element in N arrays.

e.g. 

In `n=2` arrays `[[9,3,2,4,7],[1,2,3,4,8]]`, the `3rd` largest element is `7`.

In `n=2` arrays `[[9,3,2,4,8],[1,2,3,4,2]]`, the `1st` largest element is `9`, `2nd` largest element is `8`, `3rd` largest element is `7` and etc.

## Solution
- Heap
- Sort every array in N arrays
- Keep feeding the largest number of every array in the heap
- `Poll` K times
