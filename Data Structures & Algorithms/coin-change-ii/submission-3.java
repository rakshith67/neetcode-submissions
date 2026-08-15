class Solution {

    public int change(int amount, int[] coins) {
        int length = coins.length;
        Arrays.sort(coins);
        int[][] result = new int[length + 1][amount + 1];

        for (int i = 0; i <= length; i++) {
            result[i][0] = 1;
        }

        for (int i = length - 1; i >= 0; i--) {
            for (int a = 0; a <= amount; a++) {
                if (a >= coins[i]) {
                    result[i][a] = result[i + 1][a];
                    result[i][a] += result[i][a - coins[i]];
                }
            }
        }
        return result[0][amount];
    }
}
