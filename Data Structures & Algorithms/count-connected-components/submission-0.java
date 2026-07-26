class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(list, i, visited);
                count++;
            }
        }
        return count;
    }

    private void bfs(List<List<Integer>> list, int source, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            int polled = queue.poll();
            visited[polled] = true;
            List<Integer> neighbors = list.get(polled);
            for (int neighbor: neighbors) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                }
            }
        }
    }
}
