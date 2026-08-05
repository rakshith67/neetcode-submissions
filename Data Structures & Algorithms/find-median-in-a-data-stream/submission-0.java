class MedianFinder {

    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());
        if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if (small.size() == large.size()) {
            return (double) (small.peek() + large.peek()) / 2;
        }
        return (double) small.peek();
    }
}
