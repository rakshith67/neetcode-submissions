class Solution {
    public int longestCommonSubsequence2(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] result = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    result[i][j] = 1 + result[i - 1][j - 1];
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
        return result[length1][length2];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        Integer[][] result = new Integer[length1][length2];
        return dfs(text1, text2, 0, 0, result);
    }

    private int dfs(String text1, String text2, int index1, int index2, Integer[][] result) {
        if (index1 == text1.length() || index2 == text2.length()) {
            return 0;
        }
        if (result[index1][index2] == null) {
            if (text1.charAt(index1) == text2.charAt(index2)) {
                result[index1][index2] = 1 + dfs(text1, text2, index1 + 1, index2 + 1, result);
            } else {
                result[index1][index2] = Math.max(dfs(text1, text2, index1, index2 + 1, result),
                                            dfs(text1, text2, index1 + 1, index2, result));
            }
        }

        return result[index1][index2];
    }
}
