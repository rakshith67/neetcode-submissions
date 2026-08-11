class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((p, q) -> q[0] - p[0]);

        if (a != 0) 
            queue.offer(new int[] {a, 'a'});
        if (b != 0)
            queue.offer(new int[] {b, 'b'});
        if (c != 0)
            queue.offer(new int[] {c, 'c'}); 
        
        StringBuilder builder = new StringBuilder();
        int first = -1;
        int second = -1;
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            // System.out.println(builder.toString());
            if (first == polled[1] && second == polled[1]) {
                if (queue.isEmpty()) {
                    return builder.toString();
                }
                int[] secondPolled = queue.poll();
                if (first != -1) {
                    second = first;
                }
                first = secondPolled[1];
                builder.append((char) secondPolled[1]);
                if (secondPolled[0] != 1) {
                    secondPolled[0] = secondPolled[0] - 1;
                    queue.offer(secondPolled);
                }
                queue.offer(polled);
            } else {
                if (first != -1) {
                    second = first;
                }
                first = polled[1];
                builder.append((char) polled[1]);
                if (polled[0] != 1) {
                    polled[0] = polled[0] - 1;
                    queue.offer(polled);
                }
            }
        }
        return builder.toString();
    }
}