class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (n > m) {
            return 0;
        }
        int[][] result = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(result[i], -1);
        }
        return dfs(s, t, 0, 0, result);
    }

    private int dfs(String s, String t, int i, int j, int[][] result) {
        if (j == t.length()) {
            return 1;
        }
        if (i == s.length()) {
            return 0;
        }

        if (result[i][j] == -1) {
            int current = 0;
            if (s.charAt(i) == t.charAt(j)) {
                current += dfs(s, t, i + 1, j + 1, result);
            }
            current += dfs(s, t, i + 1, j, result);
            result[i][j] = current;
        }

        return result[i][j];
    }
}
