/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        for (DirectedGraphNode node : graph) {
            if (node == s) {
                return searchNeighbors(node, t);
            }
        }
        
        return false;
    }
    
    private boolean searchNeighbors(DirectedGraphNode node, DirectedGraphNode terminal) {
        if (node == terminal) {
            return true;
        }
        
        HashMap<Integer, Boolean> hasNode = new HashMap<Integer, Boolean>();
        
        for (DirectedGraphNode neighborNode : node.neighbors) {
            hasNode.put(neighborNode.label, searchNeighbors(neighborNode, terminal));
        }
        
        return hasNode.containsValue(true);
    }
}