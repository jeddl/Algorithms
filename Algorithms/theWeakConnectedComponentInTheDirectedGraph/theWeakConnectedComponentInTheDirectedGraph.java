/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    class UnionFind {
        Map<Integer, Integer> parent;
        
        public UnionFind(HashSet<Integer> hashset) {
            parent = new HashMap<Integer, Integer>();;
            for (int nodeLabel : hashset) {
                parent.put(nodeLabel, nodeLabel);
            }
        }
        
        public int findRoot(int x) {
            if (parent.get(x) == x) {
                return x;
            }
            int parentRoot = findRoot(parent.get(x));
            parent.put(x, parentRoot);
            return parentRoot;
        }
        
        public void connect(int a, int b) {
            int root_a = findRoot(a);
            int root_b = findRoot(b);
            if (root_a != root_b) {
                parent.put(root_a, root_b);
            }
        }
    }
    
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        HashSet<Integer> hashset = new HashSet<Integer>();
        
        for (DirectedGraphNode node : nodes) {
            hashset.add(node.label);
            for (DirectedGraphNode neighbor : node.neighbors) {
                hashset.add(neighbor.label);
            }
        }
        
        UnionFind union = new UnionFind(hashset);
        
        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (union.findRoot(node.label) != union.findRoot(neighbor.label)) {
                    union.connect(node.label, neighbor.label);
                }
            }
        }
        
        return printGroups(hashset, union);
    }
    
    private List<List<Integer>> printGroups(HashSet<Integer> hashset, UnionFind union) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        
        for (int element : hashset) {
            if (!map.containsKey(union.findRoot(element))) {
                map.put(union.findRoot(element), new ArrayList<Integer>());
            }
            
            ArrayList<Integer> tempGroup = map.get(union.findRoot(element));
            tempGroup.add(element);
            map.put(union.findRoot(element), tempGroup);
        }
        
        for (ArrayList<Integer> sameRoot : map.values()) {
            Collections.sort(sameRoot);
            result.add(sameRoot);
        }
        
        return result;
    }
}