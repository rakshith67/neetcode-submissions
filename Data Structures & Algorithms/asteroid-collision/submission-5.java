class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.push(asteroids[i]);
                continue;
            }
            int current = asteroids[i];
            boolean shouldInsert = true;
            while (!stack.isEmpty() && stack.peek() > 0) {
                int second = Math.abs(current);
                int first = stack.peek();
                if (first == second) {
                    shouldInsert = false;
                    stack.pop();
                    break;
                } else if (first > second) {
                    shouldInsert = false;
                    break;
                } else {
                    shouldInsert = true;
                    stack.pop();
                }
            }
            if (shouldInsert) {
                stack.push(current);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}