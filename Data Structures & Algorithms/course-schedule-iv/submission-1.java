class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Set<Integer>> isPrerequisite = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
            isPrerequisite.add(new HashSet<>());
        }
        for (int[] prerequisite: prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
            inDegree[prerequisite[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) { 
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            List<Integer> adjacents = graph.get(vertex);
            for (int adjacent: adjacents) {
                inDegree[adjacent]--;
                isPrerequisite.get(adjacent).add(vertex);
                isPrerequisite.get(adjacent).addAll(isPrerequisite.get(vertex));
                if (inDegree[adjacent] == 0) {
                    queue.offer(adjacent);
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPrerequisite.get(query[1]).contains(query[0]));
        }
        return result;
    }
}