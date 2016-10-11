# Search In Rotated Sorted Array
# Example
Return the index of the given target in the array, otherwise return -1.
Given a rotated sorted array `[3, 4, 5, 1, 2]` and `target = 1`, return `3`.
Given `[3, 4, 5, 1, 2]` and `target = 0`, return `-1`.

# Tip
- Binary search
- Draw the figure in 2-D, then trend of the array should be obvious (NOTE: Drawing figure for this question is highly important)
- Scenario would be
```java
// middle point is on the first increment
if (array[start] < array[middle]) {
  if (target >= array[start] && target <= array[middle]) { 
    ... 
  } else {
    ...
  }
// middle point is on the second increment
} else {
  if (target <= array[end] && target >= array[middle]) {
    ...
  } else {
    ...
  }
}
```
