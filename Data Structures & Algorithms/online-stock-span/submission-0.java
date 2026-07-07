class StockSpanner {

    Stack<Integer> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty() && stack.peek() <= price) {
            count++;
            list.add(stack.pop());
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
        stack.push(price);
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */