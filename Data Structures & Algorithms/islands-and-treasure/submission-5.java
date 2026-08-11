class Solution {
    int infinity = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        if (queue.isEmpty()) {
            return;
        }
        int[][] directions = {{ -1, 0 }, { 0, -1 },
                         { 1, 0 }, { 0, 1 }};

        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            int row = polled[0];
            int column = polled[1];
            for (int[] direction: directions) {
                int currentRow = row + direction[0];
                int currentColumn = column + direction[1];

                if (currentRow < 0 || currentRow == grid.length 
                    || currentColumn  < 0 || currentColumn == grid[0].length
                        || grid[currentRow][currentColumn] != Integer.MAX_VALUE) {
                    continue;
                }
                queue.offer(new int[] {currentRow, currentColumn});
                grid[currentRow][currentColumn] = grid[row][column] + 1;
            }
        }
    }

    private void fillMinDistanceBFS(int[][] grid, boolean[][] visited, int i, int j) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(i, j, 0));
        while (!queue.isEmpty()) {
            Pair polled = queue.poll();
            int row = polled.row;
            int column = polled.column;
            int distance = polled.distance;
            visited[row][column] = true;
            grid[row][column] = Math.min(grid[row][column], distance);
            if (row > 0 && grid[row - 1][column] > 0  && !visited[row - 1][column]) {
                queue.offer(new Pair(row - 1, column, distance + 1));
            }
            if (row < grid.length - 1 && grid[row + 1][column] > 0  && !visited[row + 1][column]) {
                queue.offer(new Pair(row + 1, column, distance + 1));
            }
            if (column > 0 && grid[row][column - 1]  > 0 && !visited[row][column - 1]) {
                queue.offer(new Pair(row, column - 1, distance + 1));
            }
            if (column < grid[0].length - 1 && grid[row][column + 1] > 0 && grid[row][column + 1] != 0 && !visited[row][column + 1]) {
                queue.offer(new Pair(row, column + 1, distance + 1));
            }
        }
    }
}

class Pair {
    int row;
    int column;
    int distance;
    
    public Pair(int row, int column, int distance) {
        this.row = row;
        this.column = column;
        this.distance = distance;
    }
}
