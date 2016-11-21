public class Solution {
    public int KthInArrays(int[][] arrays, int k) {
        Queue<Node> heap = new PriorityQueue<Node>(k, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n2.value - n1.value;
            }
        });
        
        for (int i = 0; i < arrays.length; ++i) {
            Arrays.sort(arrays[i]);
            
            // Check if array is empty
            if (arrays[i].length > 0) {
                int value = arrays[i][arrays[i].length - 1];
                int index = arrays[i].length - 1;
                int id = i;
                
                heap.add(new Node(value, index, id));
            }
        }
        
        for (int i = 0; i < k; ++i) {
            Node temp = heap.poll();
            // Current node info
            int value = temp.value;
            int index = temp.index;
            int id = temp.array_id;
            
            // If it is the Kth largest
            if (i == k - 1) {
                return value;
            }
            
            // Check if it is the last(smallest) element in the array
            if (index > 0) {
                index--;
                value = arrays[id][index];
                heap.add(new Node(value, index, id));
            }
        }
        
        return -1;
    }
}

class Node {
    int value;
    int index;
    int array_id;
    
    public Node(int _value, int _index, int _id) {
        this.value = _value;
        this.index = _index;
        this.array_id = _id;
    }
}