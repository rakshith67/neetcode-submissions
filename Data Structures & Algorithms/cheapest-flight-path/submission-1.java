class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] tempPrices = Arrays.copyOf(prices, n);
            for (int[] edge: flights) {
                int u = edge[0];
                int v = edge[1];
                int price = edge[2];

                if (prices[u] == Integer.MAX_VALUE) {
                    continue;
                }

                if (prices[u] + price < tempPrices[v]) {
                    tempPrices[v] = prices[u] + price;
                }
            }
            prices = tempPrices;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

    public int findCheapestPriceDij(int n, int[][] flights, int src, int dst, int k) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight: flights) {
            graph.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[] {src, 0, 0});
        distance[src] = 0;

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int destination = polled[0];
            int currentPrice = polled[1];
            int stops = polled[2];

            if (stops > k) {
                continue;
            }

            if (destination == dst) {
                return currentPrice;
            }

            List<int[]> edges = graph.get(destination);
            for (int[] edge: edges) {
                int totalPrice = currentPrice + edge[1];
                if (totalPrice < distance[edge[0]]) {
                    distance[edge[0]] = totalPrice;
                    queue.offer(new int[] {edge[0], totalPrice, stops + 1});
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print(distance[i] + " ");
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }
}
