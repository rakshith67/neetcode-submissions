class LRUCache {

    int size;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node current = map.get(key);
            // remove current
            remove(current);
            // add current to first
            addFirst(current);
            return current.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addFirst(node);
            return;
        }

        if (size == map.size()) {
            Node toRemove = tail.prev;
            remove(toRemove);
            map.remove(toRemove.key);
        } 
        Node toInsert = new Node(key, value);
        addFirst(toInsert);
        map.put(key, toInsert);
    }

    private void addFirst(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;

        next.prev = node;
        node.next = next;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
}

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}