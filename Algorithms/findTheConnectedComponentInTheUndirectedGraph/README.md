# Find The Connected Component in The UndirectedGraph
## Example
Find the number connected component in the undirected graph. Each node in the graph contains a label and a list of its neighbors. (a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.)
`Each connected component should sort by label.`

Given graph
```
A------B  C
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      D   E
```

Return `{A,B,D}, {C,E}`. Since there are two connected component which are `{A,B,D}, {C,E}`

## Solution
- BFS
- Union Find
 - Note: HashSet can avoid duplicates
 - 
 
