class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    markIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    private void markIsland(char[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row == grid.length || column == grid[0].length) {
            return;
        }
        if (grid[row][column] == '0') {
            return;
        }
        grid[row][column] = '0';
        markIsland(grid, row - 1, column);
        markIsland(grid, row + 1, column);
        markIsland(grid, row, column - 1);
        markIsland(grid, row, column + 1);
    }
}
