class Solution {
    public int maxProfit(int[] prices) {
        int minimum = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minimum > profit) {
                profit = prices[i] - minimum;
            }
            if (prices[i] < minimum) {
                minimum = prices[i];
            }
        }
        return profit;
    }
}
