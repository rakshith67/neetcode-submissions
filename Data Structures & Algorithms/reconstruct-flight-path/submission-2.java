class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> ticket: tickets) {
            String source = ticket.get(0);
            String destination = ticket.get(1);
            map.putIfAbsent(source, new PriorityQueue<>());
            map.get(source).offer(destination);
        }

        List<String> result = new ArrayList<>();
        dfs(map, "JFK", result);
        Collections.reverse(result);
        return result;
    }

    private void dfs(Map<String, PriorityQueue<String>> map, String vertex, List<String> result) {
        PriorityQueue<String> neighbors = map.get(vertex);
        while (neighbors != null && !neighbors.isEmpty()) {
            dfs(map, neighbors.poll(), result);
        }
        result.add(vertex);
    }
}
