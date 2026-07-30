class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] result = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            result[trust[i][1]]++;
            result[trust[i][0]]--;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}