class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int columns = heights[0].length;
        boolean[][] pacific = new boolean[rows][columns];
        boolean[][] atlantic = new boolean[rows][columns];
        for (int column = 0; column < columns; column++) {
            fillByDFS(heights, 0, column, pacific);
            fillByDFS(heights, rows - 1, column, atlantic);
        }

        for (int row = 0; row < rows; row++) {
            fillByDFS(heights, row, 0, pacific);
            fillByDFS(heights, row, columns - 1, atlantic);
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void fillByDFS(int[][] heights, int row, int column, boolean[][] ocean) {
        if (row < 0 || row == heights.length || column < 0 || column == heights[0].length) {
            return;
        }
        if (ocean[row][column]) {
            return;
        }
        ocean[row][column] = true;
        if (row > 0 && heights[row - 1][column] >= heights[row][column]) {
            fillByDFS(heights, row - 1, column, ocean);
        }
        if (row < heights.length - 1 && heights[row + 1][column] >= heights[row][column]) {
            fillByDFS(heights, row + 1, column, ocean);
        }
        if (column > 0 && heights[row][column - 1] >= heights[row][column]) {
            fillByDFS(heights, row, column - 1, ocean);
        }
        if (column < heights[0].length - 1 && heights[row][column + 1] >= heights[row][column]) {
            fillByDFS(heights, row, column + 1, ocean);
        }
    }
}
