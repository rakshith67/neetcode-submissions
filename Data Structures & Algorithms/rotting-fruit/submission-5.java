class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        
        int fresh = 0;
        int time = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while (fresh > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] polled = queue.poll();
                int row = polled[0];
                int column = polled[1];
                if (row > 0 && grid[row - 1][column] == 1) {
                    queue.offer(new int[]{row - 1, column});
                    grid[row - 1][column] = 2;
                    fresh--;
                }
                if (row < rows - 1 && grid[row + 1][column] == 1) {
                    queue.offer(new int[]{row + 1, column});
                    fresh--;
                    grid[row + 1][column] = 2;
                }
                if (column > 0 && grid[row][column - 1]  == 1) {
                    queue.offer(new int[]{row, column - 1});
                    fresh--;
                    grid[row][column - 1] = 2;
                }
                if (column < columns - 1 && grid[row][column + 1] == 1) {
                    queue.offer(new int[]{row, column + 1});
                    fresh--;
                    grid[row][column + 1] = 2;
                }
            }

            time++;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        return fresh == 0 ? time : -1;
    }
}
