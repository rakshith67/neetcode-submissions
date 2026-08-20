class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        int[][] result = new int[nums.length][2 * totalSum + 1];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], Integer.MIN_VALUE);
        }
        return dfs(nums, result, 0, 0, target, totalSum);
    }

    private int dfs(int[] nums, int[][] result, int index, int sum, int target, int totalSum) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        if (result[index][sum + totalSum] != Integer.MIN_VALUE) {
            return result[index][sum + totalSum];
        }
        result[index][sum + totalSum] = dfs(nums, result, index + 1, sum + nums[index], target, totalSum)
                                    +  dfs(nums, result, index + 1, sum - nums[index], target, totalSum);
        return result[index][sum + totalSum];
    }
}
