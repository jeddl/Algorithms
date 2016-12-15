# Data Stream Median
## Example
Median is the number that in the middle of a sorted array. If there are n numbers in a sorted array `A`, the median is `A[(n - 1) / 2]`. For example, if `A = [1,2,3]`, median is `2`. If `A = [1,19]`, median is `1`.

For numbers coming list: `[1, 2, 3, 4, 5]`, return `[1, 1, 2, 2, 3]`.

For numbers coming list: `[4, 5, 1, 3, 2, 6, 0]`, return `[4, 4, 4, 3, 3, 3, 3]`.

For numbers coming list: `[2, 20, 100]`, return `[2, 2, 20]`.

`LintCode`


## Solution
- Use two priority queues as two heaps
- Left as max heap and right as min heap
- Median will always be the top element in the max heap
- If the number of elements in heaps are odd, move one from max heap to min heap
