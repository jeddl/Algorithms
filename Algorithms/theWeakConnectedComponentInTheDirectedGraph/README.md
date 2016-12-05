# The Weak Connected Component In The Directed Graph
## Example
Find the number Weak Connected Component in the directed graph. Each node in the graph contains a label and a list of its neighbors. (a connected set of a directed graph is a subgraph in which any two vertices are connected by direct edge path.)
`Sort the element in the set in increasing order`

Given graph
```
A----->B  C
 \     |  | 
  \    |  |
   \   |  |
    \  v  v
     ->D  E <- F
```
Return `{A,B,D}, {C,E,F}`. Since there are two connected component which are `{A,B,D}` and `{C,E,F}`


## Solution
- Since the labels are not continuous and might be negative numbers, array Union Find `(int[] parent)` cannot be used
- Use `HashMap<Integer, Integer> parent` instead: as `<current node, root node>`
