class Solution {
    public int maxProfit(int[] prices) {
        int[][] result = new int[prices.length][2];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], Integer.MIN_VALUE);
        }
        return dfs(0, true, prices, result);
    }

    private int dfs(int index, boolean buying, int[] prices, int[][] result) {
        if (index >= prices.length) {
            return 0;
        }
        int cooldown = dfs(index + 1, buying, prices, result);
        if (buying) {
            if (result[index][0] == Integer.MIN_VALUE) {
                int buy = dfs(index + 1, false, prices, result) - prices[index];
                result[index][0] = Math.max(buy, cooldown);
            }
            return result[index][0];
        } else {
            if (result[index][1] == Integer.MIN_VALUE) {
                int sell = dfs(index + 2, true, prices, result) + prices[index];
                result[index][1] = Math.max(sell, cooldown);
            }
            return result[index][1];
        }
    }
}
