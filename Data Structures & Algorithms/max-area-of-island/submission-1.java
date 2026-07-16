class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, maxArea(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int maxArea(int[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row == grid.length || column == grid[0].length) {
            return 0;
        }
        if (grid[row][column] != 1) {
            return 0;
        }
        grid[row][column] = 2;
        return 1 + maxArea(grid, row - 1, column) + maxArea(grid, row + 1, column)
            + maxArea(grid, row, column + 1) + maxArea(grid, row, column - 1);
    }
}
