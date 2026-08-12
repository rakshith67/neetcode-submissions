class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge: edges) {
            if (!union(parent, rank, edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }

    private int find(int[] parent, int u) {
        while (u != parent[u]) {
            u = parent[u];
        }
        return u;
    }

    private boolean union(int[] parent, int[] rank, int u, int v) {
        int parent1 = find(parent, u);
        int parent2 = find(parent, v);

        if (parent1 == parent2) {
            return false;
        }

        if (rank[parent1] >= rank[parent2]) {
            parent[parent2] = parent1;
            rank[parent1] += rank[parent2];
        } else {
            parent[parent1] = parent2;
            rank[parent2] += rank[parent1];
        }
        return true;
    }
}
