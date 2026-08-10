class MyCircularQueue {

    private int space;
    private ListNode left;
    private ListNode right;

    public MyCircularQueue(int k) {
        this.space = k;
        this.left = new ListNode(-1);
        this.right = this.left;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        ListNode toInsert = new ListNode(value);
        right.next = toInsert;
        right = right.next;
        right.next = left;
        space--;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        ListNode next = left.next;
        if (right == next) {
            right = left;
        }
        left.next = next.next;
        space++;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return left.next.val;
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return right.val;
    }
    
    public boolean isEmpty() {
        // System.out.print(left.val + " " + left.next.val + " ");
        return left.next == null || left.next == left;
    }
    
    public boolean isFull() {
        return space == 0;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */