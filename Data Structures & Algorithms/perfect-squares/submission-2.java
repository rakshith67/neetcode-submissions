class Solution {
    public int numSquares(int n) {
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; i >= j * j; j--) {
                if (i - (j * j) < 0 ||  result[i - (j * j)] == Integer.MAX_VALUE) {
                    continue;
                }
                result[i] = Math.min(result[i], 1 + result[i - (j * j)]);
            }
        }
        return result[n];
    }
}