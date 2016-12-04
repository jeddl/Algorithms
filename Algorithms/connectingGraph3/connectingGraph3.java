public class ConnectingGraph3 {
    private int[] parent = null;
    private int size;

    public ConnectingGraph3(int n) {
        parent = new int[n + 1];
        size = n;
        
        for (int i = 0; i <= n; ++i) {
            parent[i] = 0;
        }
    }

    private int findRoot(int ele) {
        if (parent[ele] == 0) {
            return ele;
        }
        parent[ele] = findRoot(parent[ele]);
        
        return parent[ele];
    }
    
    public void connect(int a, int b) {
        int root_a = findRoot(a);
        int root_b = findRoot(b);
        if (root_a != root_b) {
            parent[root_a] = root_b;
            size--;
        }
    }
        
    public int query() {
        return size;
    }
}