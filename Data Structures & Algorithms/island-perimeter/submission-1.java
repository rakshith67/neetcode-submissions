class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int maxPerimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxPerimeter = Math.max(maxPerimeter, dfs(grid, visited, i, j));
                }
            }
        }
        return maxPerimeter;
    }

    private int dfs(int[][] grid, boolean[][] visited, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length
            || grid[row][column] == 0) {
            return 1;
        }
        if (visited[row][column]) {
            return 0;
        }
        visited[row][column] = true;
        return dfs(grid, visited, row - 1, column) + dfs(grid, visited, row + 1, column)
            + dfs(grid, visited, row, column + 1) + dfs(grid, visited, row, column - 1);
    }
}