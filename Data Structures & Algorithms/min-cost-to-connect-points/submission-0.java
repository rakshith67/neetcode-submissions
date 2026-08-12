class Solution {
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int weight = Math.abs(points[j][0] - points[i][0]) +
                                Math.abs(points[j][1] - points[i][1]);
                edges.add(new int[] {weight, i, j});
            }
        }

        edges.sort((edge1, edge2) -> edge1[0] - edge2[0]);
        int weight = 0;
        int[] parent = new int[length];
        int[] rank = new int[length];
        Arrays.fill(rank, 1);
        for (int i = 0; i < length; i++) {
            parent[i] = i;
        }

        for (int[] edge: edges) {
            if (union(parent, rank, edge[1], edge[2])) {
                weight += edge[0];
            }
        }
        return weight;
    }

    private int find(int[] parent, int u) {
        int p = parent[u];
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private boolean union(int[] parent, int[] rank, int u, int v) {
        int parent1 = find(parent, u);
        int parent2 = find(parent, v);

        if (parent1 == parent2) {
            return false;
        }
        if (rank[parent1] >= rank[parent2]) {
            parent[parent1] = parent2;
            rank[parent2] += rank[parent1];
        } else {
            parent[parent2] = parent1;
            rank[parent1] += rank[parent2];
        }
        return true;
    }
}
