class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] prerequisite: prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++; 
        }

        int[] result = new int[numCourses];
        int index = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) { 
                queue.offer(i);
                result[index++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            List<Integer> adjacents = graph.get(vertex);
            for (int adjacent: adjacents) {
                inDegree[adjacent]--;
                if (inDegree[adjacent] == 0) {
                    result[index++] = adjacent;
                    queue.offer(adjacent);
                }
            }
        }
        return index != numCourses ? new int[0] : result;
    }
    
    int index;
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][1] == prerequisites[i][0]) {
                return new int[0];
            }
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] visited = new int[numCourses];
        int[] result = new int[numCourses];
        index = numCourses - 1;
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                dfs(graph, i, visited, result);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] != 2) {
                return new int[0];
            }
        }
        return result;
    }

    private void dfs(List<List<Integer>> graph, int source, int[] visited, int[] result) {
        visited[source] = 1;
        List<Integer> neighbors = graph.get(source);
        boolean hasCycle = false;
        for (Integer neighbor: neighbors) {
            if (visited[neighbor] == 0) {
                dfs(graph, neighbor, visited, result);
            } else if (visited[neighbor] == 1) {
                hasCycle = true;
            }
        }
        
        if (!hasCycle) {
            visited[source] = 2;
            result[index--] = source;
        }
    }
}
