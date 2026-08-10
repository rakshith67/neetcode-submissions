class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int currentPassengers = 0;
        for (int i = 0; i < trips.length; i++) {
            int numPassengers = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];
            while (!queue.isEmpty() && queue.peek()[0] <= start) {
                currentPassengers -= queue.poll()[1];
            }
            currentPassengers += numPassengers;
            if (currentPassengers > capacity) {
                return false;
            }

            queue.offer(new int[] {end, numPassengers});
        }
        return true;
    }
}