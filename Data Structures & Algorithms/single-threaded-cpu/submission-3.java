class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] result = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new int[] {tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(tasks, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> 
                a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int i = 0;
        int index = 0;
        int currentTime = tasks[0][0];
        while (!queue.isEmpty() || i < tasks.length) {
            while (i < tasks.length && tasks[i][0] <= currentTime) {
                queue.offer(new int[] {tasks[i][1], tasks[i][2]});
                i++;
            }
            if (queue.isEmpty()) {
                currentTime = tasks[i][0];
            } else {
                int[] task = queue.poll();
                result[index++] = task[1];
                currentTime += task[0];
            }
        }
        return result;
    }
}