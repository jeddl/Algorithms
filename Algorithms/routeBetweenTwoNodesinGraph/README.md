# Route Between 2 Nodes in Graph
## Example
Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

e.g. Given graph:
```
A----->B----->C
 \     |
  \    |
   \   |
    \  v
     ->D----->E
```
for `s = B` and `t = E`, return `true`

for `s = D` and `t = C`, return `false`

## Solution
- Method 1
 - Recursion: Search all neighbors of a node 
