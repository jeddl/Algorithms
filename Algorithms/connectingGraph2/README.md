# Connecting Graph 2
## Example
Given n nodes in a graph labeled from 1 to n. There is no edges in the graph at beginning.

You need to support the following method:

- `connect(a, b)`, add an edge to connect node `a` and node `b`. 
- `query(a)`, Returns the number of connected component nodes which include node `a`.

e.g. 
```
5 // n = 5
query(1) return 1
connect(1, 2)
query(1) return 2
connect(2, 4)
query(1) return 3
connect(1, 4)
query(1) return 3
```

## Solution
- Union Find
