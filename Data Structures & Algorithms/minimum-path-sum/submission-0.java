class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] result = new int[rows][columns];

        int sum = 0;
        for (int j = 0; j < columns; j++) {
            sum += grid[0][j];
            result[0][j] = sum;
        }
        
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int upper = result[i - 1][j];
                int left = j - 1 >= 0 ? result[i][j - 1] : Integer.MAX_VALUE;
                result[i][j] = Math.min(upper, left) + grid[i][j];
            }
        }

        return result[rows - 1][columns - 1];
    }
}