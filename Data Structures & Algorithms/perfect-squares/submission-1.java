class Solution {
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        int[] squares = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            squares[i] = i * i;
        }

        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - squares[j] < 0 ||  result[i - squares[j]] == Integer.MAX_VALUE) {
                    continue;
                }
                result[i] = Math.min(result[i], 1 + result[i - squares[j]]);
            }
        }
        return result[n];
    }
}