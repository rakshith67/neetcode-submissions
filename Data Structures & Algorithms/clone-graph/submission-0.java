/*
Definition for a Node.
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
        if (node == null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        Node root = null;
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node polled = queue.poll();
            if (visited.get(polled.val) != null) {
                continue;
            }
            Node newNode = null;
            if (map.get(polled.val) == null) {
                newNode = new Node(polled.val);
                map.put(polled.val, newNode);
                if (root == null) {
                    root = newNode;
                }
            } else {
                newNode = map.get(polled.val);
            }
            for (Node child: polled.neighbors) {
                Node newChildNode;
                if (map.get(child.val) == null) {
                    newChildNode = new Node(child.val);
                } else {
                    newChildNode = map.get(child.val);
                }
                map.put(child.val, newChildNode);
                newNode.neighbors.add(newChildNode);
                queue.offer(child);
            }
            visited.put(polled.val, true);
        }
        return root;
    }
}