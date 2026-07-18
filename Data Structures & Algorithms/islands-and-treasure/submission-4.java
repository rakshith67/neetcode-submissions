class Solution {
    int infinity = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    fillMinDistanceBFS(grid, visited, i, j);
                    visited = new boolean[grid.length][grid[0].length];
                }
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
