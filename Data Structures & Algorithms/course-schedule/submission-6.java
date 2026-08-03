class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][1] == prerequisites[i][0]) {
                return false;
            }
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(graph, i, visited);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] != 2) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> list, int source, int[] visited) {
        visited[source] = 1;
        List<Integer> neighbors = list.get(source);
        boolean alreadyVisited = false;
        for (Integer neighbor: neighbors) {
            if (visited[neighbor] == 0) {
                dfs(list, neighbor, visited);
            } else if (visited[neighbor] == 1) {
                alreadyVisited = true;
            }
        }
        if (!alreadyVisited) {
            visited[source] = 2;
        }
    }
}
