class Solution {
    public String simplifyPath(String path) {
        char[] pathArray = (path + "/").toCharArray();
        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();
        for (char ch: pathArray) {
            if (ch == '/') {
                if (current.toString().equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    if (!current.toString().isEmpty() && !current.toString().equals(".")) {
                        stack.push(current.toString());
                    }
                }
                current.setLength(0);
            } else {
                current.append(ch);
            }
        }
        current.setLength(0);
        while (!stack.isEmpty()) {
            current.insert(0, stack.pop());
            if (!stack.isEmpty()) {
                current.insert(0, '/');
            }
        }
        return "/" + current.toString();
    }
}