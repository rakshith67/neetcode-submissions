class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 1; i < n; i++) {
            result.put(i, Integer.MAX_VALUE);
        }
        result.put(src, 0);
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(List<Integer> edge: edges) {
            graph.get(edge.get(0)).add(new int[] {edge.get(1), edge.get(2)});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[] {src, 0});

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int distance = polled[1];
            int vertex = polled[0];

            for (int[] edge: graph.get(vertex)) {
                if (distance + edge[1] < result.get(edge[0])) {
                    result.put(edge[0], distance + edge[1]);
                    queue.offer(new int[] { edge[0], distance + edge[1] });
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!result.containsKey(i) || result.get(i) == Integer.MAX_VALUE) {
                result.put(i, -1);
            }
        }

        return result;
    }  
}
