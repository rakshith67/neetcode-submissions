class Solution {
    public int evalRPN(String[] tokens) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String current = tokens[i];
            if ("+".equals(current)) { 
                int first = stack.pop();
                int second = stack.pop();
                stack.push (first + second);
            } else if ("-".equals(current)) { 
                int first = stack.pop();
                int second = stack.pop();
                stack.push (second - first);
            } else if ("*".equals(current)) { 
                int first = stack.pop();
                int second = stack.pop();
                stack.push (second * first);
            } else if ("/".equals(current)) { 
                int first = stack.pop();
                int second = stack.pop();
                stack.push (second / first);
            } else {
                int number = toNumber(current);
                stack.push(number);
            }
        }
        return stack.pop();
    }

    private int toNumber(String string) {
        int number = 0;
        boolean isNegative = false;
        for (int i = 0; i < string.length(); i++) {
            if (i == 0 && string.charAt(i) == '-') {
                isNegative = true;
                continue;
            }
            number = number * 10 + (string.charAt(i) - '0');
        }
        return isNegative ? -number : number;
    }
}
