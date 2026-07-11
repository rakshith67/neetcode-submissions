class Solution {
    public int leastInterval(char[] tasks, int n) {
        int max = 0;
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            int index = tasks[i] - 'A';
            count[index]++;
            if (count[index] > max) {
                max = count[index];
            }
        }
        Arrays.sort(count);
        int idle = (max - 1) * n;
        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(max - 1, count[i]);
        }

        return Math.max(0, idle) + tasks.length;
    }
}
