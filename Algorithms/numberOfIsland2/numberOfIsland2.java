/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int convertToIndex(int row, int col, int m) {
        return row * m + col;
    }
    
    class UnionFind {
        HashMap<Integer, Integer> parent;
        
        public UnionFind(int n, int m) {
            parent = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    int index = convertToIndex(i, j, m);
                    this.parent.put(index, index);
                }
            }
        }
        
        public int findRoot(int x) {
            if (parent.get(x) == x) {
                return x;
            }
            int getParent = findRoot(parent.get(x));
            parent.put(x, getParent);
            return getParent;
        }
        
        public void connect(int a, int b) {
            int root_a = findRoot(a);
            int root_b = findRoot(b);
            if (root_a != root_b) {
                parent.put(root_a, root_b); 
            }
        }
    } 
    
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> result = new ArrayList<Integer>();
        if (operators == null) {
            return result;
        }
        
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        int[][] island = new int[n][m];
        
        UnionFind union = new UnionFind(n, m);
        int count = 0;
        
        for (int i = 0; i < operators.length; ++i) {
            count++;
            int x = operators[i].x;
            int y = operators[i].y;
            
            if (island[x][y] != 1) {
                island[x][y] = 1;
                int index = convertToIndex(x, y, m);
                
                for (int j = 0; j < 4; ++j) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && island[nx][ny] == 1) {
                        int nIndex = convertToIndex(nx, ny, m);
                        int root = union.findRoot(index);
                        int nroot = union.findRoot(nIndex);
                        
                        if (root != nroot) {
                            count--;
                            union.connect(index, nIndex);
                        }
                    }
                }
            }
            result.add(count);
        }
        
        return result;
    }
}