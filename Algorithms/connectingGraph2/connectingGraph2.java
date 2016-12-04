public class ConnectingGraph2 {
    private int[] parent = null;
    private int[] size = null;
    
    public ConnectingGraph2(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            parent[i] = 0;
            size[i] = 1;
        }
    }

    public void connect(int a, int b) {
        int root_a = findRoot(a);
        int root_b = findRoot(b);
        if (root_a != root_b) {
            parent[root_a] = root_b;
            size[root_b] += size[root_a];
        }
    }
        
    public int query(int a) {
        int root_a = findRoot(a);
        return size[root_a];
    }
    
    private int findRoot(int ele) {
        if (parent[ele] == 0) {
            return ele;
        }
        
        parent[ele] = findRoot(parent[ele]);
        
        return parent[ele];
    }
}