class Solution {

    int numberOfComponents = 0;

    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        numberOfComponents = n;
        for (int[] edge: edges) {
            if (!union(rank, parent, edge[0], edge[1])) {
                return false;
            }
        }
        return numberOfComponents == 1;
    }

    private int find(int[] parent, int u) {
        int p = parent[u];
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private boolean union(int[] rank, int[] parent, int u, int v) {
        int parent1 = find(parent, u);
        int parent2 = find(parent, v);

        if (parent1 == parent2) {
            return false;
        }
        numberOfComponents--;
        if (rank[parent1] >= rank[parent2]) {
            parent[parent2] = parent1;
            rank[parent1] += rank[parent2];
        } else {
            parent[parent1] = parent2;
            rank[parent2] += rank[parent1];
        }

        return true;
    }

    public boolean validTree2(int n, int[][] edges) {
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
