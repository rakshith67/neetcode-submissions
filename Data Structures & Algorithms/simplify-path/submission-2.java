class Solution {
    public String simplifyPath(String path) {
        char[] pathArray = (path + "/").toCharArray();
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (char ch: pathArray) {
            if (ch == '/') {
                if (!builder.isEmpty() && "..".equals(builder.toString())) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!builder.isEmpty() && !".".equals(builder.toString())) {
                    stack.push(builder.toString());
                }
                builder.setLength(0); 
            } else {
                builder.append(ch);
            }
        }
        builder.setLength(0);
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
            if (!stack.isEmpty()) {
                builder.insert(0, '/');
            }
        }
        return "/" + builder.toString();
    }
}