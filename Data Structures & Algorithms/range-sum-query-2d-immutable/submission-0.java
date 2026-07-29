class NumMatrix {

    int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        prefixSum = new int[matrix.length][matrix[0].length];
        int sum = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            sum += matrix[0][j];
            prefixSum[0][j] = sum;
        }

        sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][0];
            prefixSum[i][0] = sum;
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] + matrix[i][j] - prefixSum[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = prefixSum[row2][col2];
        if (col1 - 1 >= 0) {
            sum -= prefixSum[row2][col1 - 1];
        }

        if (row1 - 1 >= 0) {
            sum -= prefixSum[row1 - 1][col2];
        }

        if (row1 - 1>= 0&& col1 - 1 >= 0) {
            sum += prefixSum[row1 - 1][col1 - 1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */