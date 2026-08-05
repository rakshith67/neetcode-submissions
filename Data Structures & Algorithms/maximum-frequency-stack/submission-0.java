class FreqStack {
    Map<Integer, Integer> frequency;
    List<Stack<Integer>> stacks;

    public FreqStack() {
        frequency = new HashMap<>();
        stacks = new ArrayList<>();
        stacks.add(new Stack<>());
    }
    
    public void push(int val) {
        Integer currentCount = frequency.getOrDefault(val, 0) + 1;
        frequency.put(val, currentCount);
        if (currentCount == stacks.size()) {
            stacks.add(new Stack<>());
        }
        stacks.get(currentCount).push(val);
    }
    
    public int pop() {    
        if (stacks.size() == 1) {
            return -1;
        }
        Stack<Integer> stack = stacks.get(stacks.size() - 1);
        int i = 1;
        while (i <= stacks.size() && stack.isEmpty()) {
            stack = stacks.get(stacks.size() - i);
            i++;
        }
        int popped = stack.pop();
        int freq = frequency.get(popped);
        frequency.put(popped, freq - 1);
        return popped;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */