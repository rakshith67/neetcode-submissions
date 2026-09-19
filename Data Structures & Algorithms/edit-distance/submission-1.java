class Solution {
    public int minDistanceBU(String word1, String word2) {
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

    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] result = new int[length1][length2];

        for (int i = 0; i < length1; i++) {
            Arrays.fill(result[i], -1);
        }

        return minDistance(word1, word2, 0, 0, result);
    }

    public int minDistance(String word1, String word2, int index1, int index2, int[][] result) {
        if (index1 == word1.length()) {
            return word2.length() - index2;
        }

        if (index2 == word2.length()) {
            return word1.length()  - index1;
        }

        if (result[index1][index2] == -1) {
            if (word1.charAt(index1) == word2.charAt(index2)) {
                result[index1][index2] = minDistance(word1, word2, index1 + 1, index2 + 1, result);
            } else {
                int delete = 1 + minDistance(word1, word2, index1 + 1, index2, result);
                int insert = 1 + minDistance(word1, word2, index1, index2 + 1, result);
                int replace = 1 + minDistance(word1, word2, index1 + 1, index2 + 1, result);
                result[index1][index2] = Math.min(insert, delete);
                result[index1][index2] = Math.min(result[index1][index2], replace);
            }
        }

        return result[index1][index2];
    }
}
