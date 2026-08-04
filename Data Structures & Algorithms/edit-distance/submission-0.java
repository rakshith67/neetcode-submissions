class Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] result = new int[length1 + 1][length2 + 1];

        for (int j = 0; j <= length2; j++) {
            result[length1][j] = length2 - j;
        }

        for (int i = 0; i <= length1; i++) {
            result[i][length2] = length1 - i;
        }

        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = length2 - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    result[i][j] = result[i + 1][j + 1];
                } else {
                    result[i][j] = 1 + Math.min(result[i + 1][j],
                            Math.min(result[i][j + 1], result[i + 1][j + 1]));
                }
            }
        }
        return result[0][0];
    }
}
