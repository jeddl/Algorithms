public class ConnectingGraph { 
    private int[] father = null;
    
    public ConnectingGraph(int n) {
        // Initialize data structure here -> common root here is 0
        father = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            father[i] = 0;
        }
    }
    
    // Find the root
    private int findRoot(int x) {
        if (father[x] == 0) {
            return x;
        }
        father[x] = findRoot(father[x]);
        return father[x];
    }    

    // Connect root
    public void connect(int a, int b) {
        int root_a = findRoot(a);
        int root_b = findRoot(b);
        if (root_a != root_b) {
            father[root_a] = root_b;    
        }
    }
        
    public boolean  query(int a, int b) {
        int root_a = findRoot(a);
        int root_b = findRoot(b);
        return root_a == root_b;
    }
}