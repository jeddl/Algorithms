/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<UndirectedGraphNode, Boolean>();
        
        for (UndirectedGraphNode node : nodes) {
            visited.put(node, false);
        }
        
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        
        for (UndirectedGraphNode node : nodes) {
            if (visited.get(node) == false) {
                bfs(visited, node, rst);
            }
        }
        
        return rst;
    }
    private void bfs(Map<UndirectedGraphNode, Boolean> visited, UndirectedGraphNode node, List<List<Integer>> rst) {
        
        List<Integer> temp = new ArrayList<Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        visited.put(node, true);
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode u = queue.poll();
            temp.add(u.label);
            
            for (UndirectedGraphNode i : u.neighbors) {
                if (visited.get(i) == false) {
                    visited.put(i, true);
                    queue.offer(i);
                }
            }
        }
        
        Collections.sort(temp);
        rst.add(temp);
    }
}
