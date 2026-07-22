class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int[][] result = new int[rows][columns];

        for (int j = 0; j < columns; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            result[0][j] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                int upper = result[i - 1][j];
                int left = j == 0 ? 0 : result[i][j - 1];
                result[i][j] = upper + left;
            }
        }

        return result[rows - 1][columns - 1];
    }
}