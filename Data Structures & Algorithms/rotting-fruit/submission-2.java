class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] minutes = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    minutes[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    fillBFS(grid, minutes, i, j);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(minutes[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, minutes[i][j]);
                }
                
            }
        }
        return max == Integer.MAX_VALUE ? - 1: max;
    }

    private void fillBFS(int[][] grid, int[][] minutes, int r, int c) {
        Queue<Pair> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.offer(new Pair(r, c, 0));
        while (!queue.isEmpty()) {
            Pair polled = queue.poll();
            int row = polled.row;
            int column = polled.column;
            int minute = polled.minute;
            visited[row][column] = true;
            minutes[row][column] = Math.min(polled.minute, minutes[row][column]);
            if (row > 0 && grid[row - 1][column] == 1 && !visited[row - 1][column]) {
                queue.offer(new Pair(row - 1, column, minute + 1));
            }
            if (row < grid.length - 1 && grid[row + 1][column] == 1  && !visited[row + 1][column]) {
                queue.offer(new Pair(row + 1, column, minute + 1));
            }
            if (column > 0 && grid[row][column - 1]  == 1 && !visited[row][column - 1]) {
                queue.offer(new Pair(row, column - 1, minute + 1));
            }
            if (column < grid[0].length - 1 && grid[row][column + 1] == 1 && !visited[row][column + 1]) {
                queue.offer(new Pair(row, column + 1, minute + 1));
            }
        }
    }
}

class Pair {
    int row;
    int column;
    int minute;
    
    public Pair(int row, int column, int minute) {
        this.row = row;
        this.column = column;
        this.minute = minute;
    }
}
