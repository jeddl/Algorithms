public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1 || edges == null) {
            return false;
        }
        UnionFind union = new UnionFind(n);
        for (int i = 0; i < edges.length; ++i) {
            if (union.findRoot(edges[i][0]) == union.findRoot(edges[i][1])) {
                return false;
            }
            union.connect(edges[i][0], edges[i][1]);
        }

        return true;
    }
}

class UnionFind {
    private int[] parent = null;
    
    public UnionFind(int n) {
        parent = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            parent[i] = -1;
        }
    }
    
    public void connect(int a, int b) {
        int root_a = findRoot(a);
        int root_b = findRoot(b);
        if (root_a != root_b) {
            parent[root_a] = root_b;
        }
    }
    
    public int findRoot(int ele) {
        if (parent[ele] == -1) {
            return ele;
        }
        
        parent[ele] = findRoot(parent[ele]);
        
        return parent[ele];
    }
}