class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] result = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            Arrays.fill(result[i], -1);
        }
        return dfs(s1, s2, s3, 0, 0, 0, result);
    }

    private boolean dfs(String s1, String s2, String s3, int index1, int index2, int index3, int[][] result) {
        if (result[index1][index2] != -1) {
            return result[index1][index2] == 1 ? true : false;
        }

        if (index1 == s1.length() && index2 == s2.length() && index3 == s3.length()) {
            result[index1][index2] = 1;
            return true;
        } else if (index3 == s3.length()) {
            result[index1][index2] = 0;
            return false;
        } else {
            if (index1 < s1.length()) {
            if (s1.charAt(index1) == s3.charAt(index3)) {
                if (dfs(s1, s2, s3, index1 + 1, index2, index3 + 1, result)) {
                    result[index1][index2] = 1;
                    return true;
                }
            }
        }
        if (index2 < s2.length()) {
            if (s2.charAt(index2) == s3.charAt(index3)) {
                if (dfs(s1, s2, s3, index1, index2 + 1, index3 + 1, result)) {
                    result[index1][index2] = 1;
                    return true;
                }
            }
        }
        }

        result[index1][index2] = 0;
        return false;
    }
}
