class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        int[][] distance = new int[rows][columns];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[0][0] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[] {0, 0, 0});

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int diff = polled[0];
            int row = polled[1];
            int column = polled[2];

            if (row == rows - 1 && column == columns - 1) {
                return diff;
            }

            if (distance[row][column] < diff) {
                continue;
            }

            for (int[] direction: directions) {
                int newRow = row + direction[0];
                int newColumn = column + direction[1];

                if (newRow < 0 || newColumn < 0 || newRow == rows || newColumn == columns) {
                    continue;
                }

                int newDiff = Math.max(diff, Math.abs(heights[row][column] - heights[newRow][newColumn]));

                if (newDiff < distance[newRow][newColumn]) {
                    // System.out.println(newRow + " " + newColumn + " " + newDiff);
                    distance[newRow][newColumn] = newDiff;
                    queue.offer(new int[] {newDiff, newRow, newColumn});
                }

            }
        }
        return 0;
    }
}