class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        
        if (!bfs(list, 0, visited)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean bfs(List<List<Integer>> list, int source, boolean[] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {source, -1});
        visited[source] = true;
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int vertex = polled[0];
            int parent = polled[1];

            List<Integer> neighbors = list.get(vertex);
            for (int neighbor: neighbors) {
                if (!visited[neighbor]) {
                    queue.offer(new int[] {neighbor, vertex});
                    visited[neighbor] = true;
                } else {
                    if (neighbor != parent) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
