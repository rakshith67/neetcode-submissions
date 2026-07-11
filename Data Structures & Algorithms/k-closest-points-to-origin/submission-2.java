class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<LengthToCordinates> queue = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int distance = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            if (queue.size() < k || distance < queue.peek().length) {
                // System.out.println(points[i][0] + " " + points[i][1]);
                queue.offer(new LengthToCordinates(points[i][0], points[i][1], distance));
                if (queue.size() > k) {
                    LengthToCordinates polled = queue.poll();
                    // System.out.println("polled " + polled.x + " " + polled.y);
                }
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        while (!queue.isEmpty()) {
            LengthToCordinates lToC = queue.poll();
            result[index][0] = lToC.x;
            result[index][1] = lToC.y;
            index++;
        }
        return result;
    }

    private class LengthToCordinates implements Comparable<LengthToCordinates> {
        int x;
        int y;
        int length;

        public LengthToCordinates(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }

        public int compareTo(LengthToCordinates l2) {
            return l2.length - length;
        }
    }
}
