class Solution {
    public int[] getOrder(int[][] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new int[] {tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(tasks, Comparator.comparingInt(t -> t[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) ->
            a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );

        int[] result = new int[tasks.length];
        int i = 0;
        int index = 0;
        long previousTime = tasks[0][0];
        while (!queue.isEmpty() || i < tasks.length) {
            while (i < tasks.length && previousTime >= tasks[i][0]) {
                queue.offer(new int[] {tasks[i][1], tasks[i][2]});
                i++;
            }
            if (queue.isEmpty()) {
                previousTime = tasks[i][0];
            } else {
                int[] task = queue.poll();
                previousTime += task[0];
                result[index++] = task[1];
            }
        }
        return result;
    }
}