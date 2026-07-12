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

        int numberOfMax = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] == max) {
                numberOfMax++;
            }
        }
        int idle = (max - 1) * (n + 1) + numberOfMax;
        return Math.max(tasks.length, idle);
    }
}
