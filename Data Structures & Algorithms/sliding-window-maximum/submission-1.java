class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length + 1 - k];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int start = 0;
        int end = 0;
        int index = 0;
        while (end < nums.length) {
            while (!queue.isEmpty() && queue.getLast() < nums[end]) {
                queue.removeLast();
            }
            queue.addLast(nums[end]);
            if (end - start + 1 == k) {
                result[index++] = queue.getFirst();
                if (nums[start] == queue.getFirst()) {
                    queue.removeFirst();
                }
                start++;
            }
            end++;
        }
        return result;
    }
}
