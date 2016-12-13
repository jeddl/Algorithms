public class Solution {
    class Bar {
        public int x;
        public int y;
        public int h;
        
        public Bar(int xx, int yy, int hh) {
            this.x = xx;
            this.y = yy;
            this.h = hh;
        }
    }
    
    class BarComparator implements Comparator<Bar> {
        public int compare (Bar b1, Bar b2) {
            return b1.h - b2.h;
        }    
    }
    
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};
    
    public int trapRainWater(int[][] heights) {
        if (heights.length == 0) {
            return 0;
        }
        
        Queue<Bar> q = new PriorityQueue<Bar>(1, new BarComparator());
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visited = new boolean[n][m];
        
        //Initiate 4 edges of the matrix
        for (int i = 0; i < n; ++i) {
            q.offer(new Bar(i, 0, heights[i][0]));
            q.offer(new Bar(i, m - 1, heights[i][m - 1]));
            visited[i][0] = true;
            visited[i][m - 1] = true;
        }
        for (int j = 0; j < m; ++j) {
            q.offer(new Bar(0, j, heights[0][j]));
            q.offer(new Bar(n - 1, j, heights[n - 1][j]));
            visited[0][j] = true;
            visited[n - 1][j] = true;
        }
        
        int result = 0;
        
        while (!q.isEmpty()) {
            Bar currBar = q.poll();
            
            for (int i = 0; i < 4; ++i) {
                int nx = currBar.x + dx[i];
                int ny = currBar.y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Bar(nx, ny, Math.max(currBar.h, heights[nx][ny])));
                    result += Math.max(0, currBar.h - heights[nx][ny]);
                }
            }
        }
        
        return result;
    }
};