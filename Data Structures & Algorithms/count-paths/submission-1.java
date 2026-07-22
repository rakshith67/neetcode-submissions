class Solution {
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for (int j = 0; j < n; j++) {
            result[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int upper = result[i - 1][j];
                int left = j - 1 >= 0 ? result[i][j - 1] : 0;
                result[i][j] = upper + left;
            }
        }
        return result[m - 1][n - 1];
    }
}
