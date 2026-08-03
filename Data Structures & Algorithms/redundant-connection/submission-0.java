class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int vertices = edges.length + 1;
        int[] inDegree = new int[vertices];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            list.add(new ArrayList<>());
        }

        //Populate the graph and indegree
        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
            inDegree[edges[i][0]]++;
            inDegree[edges[i][1]]++;
        }
        
        //Add inDegree 1 vertices to queue
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            inDegree[vertex]--;
            List<Integer> neighbors = list.get(vertex);
            for (Integer neighbor: neighbors) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 1) {
                    queue.offer(neighbor);
                }
            }
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            int u = edges[i][0], v = edges[i][1];
            if (inDegree[u] == 2 && inDegree[v] > 0) {
                return new int[]{u, v};
            }
        }
        return new int[0];
    }
}
