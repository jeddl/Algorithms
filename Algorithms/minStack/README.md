# Min Stack
## Example
Implement a stack with min() function, which will return the smallest number in the stack. It should support push, pop and min operation all in O(1) cost.
NOTE: min operation will never be called if there is no number in the stack.

e.g.
```
push(1)
pop()   // return 1
push(2)
push(3)
min()   // return 2
push(1)
min()   // return 1
```

## Solution
 - Create two stacks: stack as a container and minStack as the one which only keeps the min
 - Make sure the number of elements are equaled in these two
