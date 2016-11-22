public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Node> heap = new PriorityQueue<Node>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });
        
        int n = matrix.length;
        
        for (int i = 0; i < n; ++i) {
            if (matrix[i].length > 0) {
                int id = i;
                int index = 0;
                int val = matrix[i][index];
                
                heap.add(new Node(id, index, val));
            }
        }
        
        for (int i = 0; i < k; ++i) {
            Node temp = heap.poll();
            int id = temp.row_id;
            int index = temp.index;
            int value = temp.value;
            
            if (i == k - 1) {
                return value;
            }
            
            if (index < matrix[id].length - 1) { 
                index++; 
                heap.add(new Node(id, index, matrix[id][index]));    
            }
        }
        
        return -1;
    }
}

class Node {
    int row_id;
    int index;
    int value;
    
    public Node(int _id, int _index, int _val) {
        this.row_id = _id;
        this.index = _index;
        this.value = _val;
    }
}
