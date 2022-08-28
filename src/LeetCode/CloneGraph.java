package LeetCode;

public class CloneGraph {
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) return null;
            HashMap<Integer, Node> map = new HashMap<>();
            return dfs(node, map);
        }

        // always return the deep copied node
        public Node dfs(Node node, HashMap<Integer, Node> map) {
            if (map.containsKey(node.val)) {
                return map.get(node.val);
            }

            Node newNode = new Node(node.val);
            // neighbours down the recursive stack might use a deep copied node that does not have its neighbor filled
            // initially. However,
            // no need to put neighbours in and still work because we will still use the same reference in the hashmap
            // and insert the neighbouring node up the recursive stack.
            map.put(node.val, newNode);

            for (Node neighborNode : node.neighbors) {
                Node copiedNode = dfs(neighborNode, map);
                newNode.neighbors.add(copiedNode);
            }

            return newNode;
        }
    }
}
