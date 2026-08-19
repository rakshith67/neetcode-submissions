class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> current = equations.get(i);
            String a = current.get(0);
            String b = current.get(1);
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(new Pair (b, values[i]));
            graph.get(b).add(new Pair (a, 1 / values[i]));
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            result[i] = dfs(graph, src, target, new HashSet<>());
        }
        return result;
    }

    private double dfs(Map<String, List<Pair>> graph, String source, String target, Set<String> visited) {
        if (!graph.containsKey(source) || !graph.containsKey(target)) {
            return -1.0;
        }

        if (source.equals(target)) {
            return 1.0;
        }
        visited.add(source);
        List<Pair> neighbors = graph.get(source);
        for (Pair neighbor: neighbors) {
            if (!visited.contains(neighbor.node)) {
                double current = dfs(graph, neighbor.node, target, visited);
                if (current != -1.0) {
                    return current * neighbor.weight;
                }
            }
        }

        return -1.0;
    }

    class Pair {
        String node;
        double weight;

        Pair(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}