class StockSpanner {

    Stack<List<Integer>> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() && stack.peek().get(0) <= price) {
            count += stack.pop().get(1);
        }
        list.add(price);
        list.add(count);
        stack.push(list);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */