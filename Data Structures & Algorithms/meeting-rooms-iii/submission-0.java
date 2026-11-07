class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int[] count = new int[n];
        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return Long.compare(a[0], b[0]);
            }
            return Long.compare(a[1], b[1]);
        });

        for (int i = 0; i < n; i++) {
            free.offer(i);
        }

        for (int[] meeting: meetings) {
            while (!busy.isEmpty() && busy.peek()[1] < meeting[0]) {
                free.offer((int) busy.poll()[0]);
            }

            if (!free.isEmpty()) {
                int number = free.poll();
                busy.offer(new long[] {number, meeting[1]});
                count[number]++;
            } else {
                long[] current = busy.poll();
                long number = current[0];
                long end = current[1] + meeting[1] - meeting[0];
                busy.offer(new long[] {number, end});
                count[(int) number]++;
            }
        }

        int max = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                result = i;
            }
        }

        return result;
    }
}