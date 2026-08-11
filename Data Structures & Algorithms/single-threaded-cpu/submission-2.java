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
            while (i < tasks.length && currentTime >= tasks[i][0]) {
                queue.offer(new int[] {tasks[i][1], tasks[i][2]});
                i++;
            }
            if (queue.isEmpty()) {
                currentTime = tasks[i][0];
            } else {
                int[] task = queue.poll();
                currentTime += task[0];
                result[index++] = task[1];
            }
        }
        return result;
    }
}