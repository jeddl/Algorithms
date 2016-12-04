/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    class UnionFind {
        Map<Integer, Integer> parent = new HashMap<Integer, Integer>();
        
        public UnionFind(HashSet<Integer> set) {
            for (int curr : set) {
                parent.put(curr, curr);
            }
        }
        
        public int findRoot(int ele) {
            if (parent.get(ele) == ele) {
                return ele;
            }
            
            int parentRoot = findRoot(parent.get(ele));
            parent.put(ele, parentRoot);
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
    
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (UndirectedGraphNode node : nodes) {
            set.add(node.label);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                set.add(neighbor.label);
            }
        }
        
        UnionFind union = new UnionFind(set);
        
        for (UndirectedGraphNode node : nodes) {
            for (UndirectedGraphNode neighbor : node.neighbors) {
                int currLabel = node.label;
                int neighborLabel = neighbor.label;
                if (union.findRoot(currLabel) != union.findRoot(neighborLabel)) {
                    union.connect(currLabel, neighborLabel);
                }
            }
        }
        
        return printOut(union, nodes.size(), set);
    }
    
    public List<List<Integer>> printOut(UnionFind union, int size, HashSet<Integer> set) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int element : set) {
            int tempRoot = union.findRoot(element);
            if (!map.containsKey(tempRoot)) {
                map.put(tempRoot, new ArrayList<Integer>());
            }
            ArrayList<Integer> tempGroup = map.get(tempRoot);
            tempGroup.add(element);
            map.put(tempRoot, tempGroup);
        }
        
        for (List<Integer> group : map.values()) {
            Collections.sort(group);
            result.add(group);
        }
        
        return result;
    }
}
