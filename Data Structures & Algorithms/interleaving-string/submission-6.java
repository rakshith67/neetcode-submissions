class Solution {
    public boolean isInterleaveBU(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean[][] result = new boolean[m + 1][n + 1];
        result[m][n] = true; 

        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i < m && s1.charAt(i) == s3.charAt(i + j) && result[i + 1][j]) {
                    result[i][j] = true;
                }
                if (j < n && s2.charAt(j) == s3.charAt(i + j) && result[i][j + 1]) {
                    result[i][j] = true;
                }
            }
        }
        return result[0][0]; 
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] result = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, s3, 0, 0, 0, result);
    }

    private boolean dfs(String s1, String s2, String s3, int index1, int index2, int index3, Boolean[][] result) {
        if (result[index1][index2] != null) {
            return result[index1][index2];
        }

        if (index3 == s3.length()) {
            boolean isInterleaving = index1 == s1.length() && index2 == s2.length();
            result[index1][index2] = isInterleaving;
            return isInterleaving;
        } else {
            if (index1 < s1.length()) {
                if (s1.charAt(index1) == s3.charAt(index3)) {
                    if (dfs(s1, s2, s3, index1 + 1, index2, index3 + 1, result)) {
                        result[index1][index2] = true;
                        return true;
                    }
                }
            }
            if (index2 < s2.length()) {
                if (s2.charAt(index2) == s3.charAt(index3)) {
                    if (dfs(s1, s2, s3, index1, index2 + 1, index3 + 1, result)) {
                        result[index1][index2] = true;
                        return true;
                    }
                }
            }
        }
        result[index1][index2] = false;
        return false;
    }
}
