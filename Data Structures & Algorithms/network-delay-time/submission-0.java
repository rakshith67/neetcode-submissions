class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time: times) {
            graph.get(time[0]).add(new int[] {time[1], time[2]});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[] {k, 0});
        distance[k] = 0;

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int vertex = polled[0];
            int currentDistance = polled[1];
            List<int[]> edges = graph.get(vertex);
            for (int[] edge: edges) {
                if (currentDistance + edge[1] < distance[edge[0]]) {
                    distance[edge[0]] = currentDistance + edge[1];
                    queue.offer(new int[] {edge[0], distance[edge[0]]});
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print(distance[i] + " ");
            max = Math.max(max, distance[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}

