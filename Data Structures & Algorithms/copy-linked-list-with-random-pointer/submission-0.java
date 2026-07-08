/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node result = new Node(-1);
        Node prev = result;
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            prev.next = newNode;
            prev = newNode;
            temp = temp.next;
        }
        temp = head;
        Node newNode = null;
        while (temp != null) {
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }

        return result.next;
    }
}
