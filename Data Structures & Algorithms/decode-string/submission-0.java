class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = 0;
                while (Character.isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                countStack.push(number);
            } else if (ch == '[') {
                StringBuilder builder = new StringBuilder();
                stack.push(builder);
            } else if (ch == ']') {
                StringBuilder current = stack.pop();
                String toAppend = current.toString();
                int count = countStack.pop();
                for (int j = 0; j < count - 1; j++) {
                    current.append(toAppend);
                }
                if (stack.isEmpty()) {
                    stack.push(current);
                } else {
                    stack.peek().append(current.toString());
                }
            } else {
                if (stack.isEmpty()) {
                    stack.push(new StringBuilder());
                }
                stack.peek().append(ch);
            }
        }
        return stack.pop().toString();
    }
}