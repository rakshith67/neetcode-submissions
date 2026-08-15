class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            if (n <= 2) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int polled = queue.poll();
                n--;
                List<Integer> adjacents = graph.get(polled);
                for (Integer adjacent: adjacents) {
                    inDegree[adjacent]--;
                    if (inDegree[adjacent] == 1) {
                        queue.offer(adjacent);
                    } 
                }
            }
        } 
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }
}