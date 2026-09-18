class Solution {
    public boolean canPartitionBU(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] result = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            result[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    result[i][j] = result[i - 1][j] || result[i - 1][j - nums[i - 1]];
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        return result[n][target];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        Boolean[][] result = new Boolean[nums.length][target + 1];
        return canPartitionDFS(nums, 0, target, target, result);
    }

    private boolean canPartitionDFS(int[] nums, int index, int sum, int target, Boolean[][] result) {
        if (0 == sum) {
            return true;
        }
        if (sum < 0 || index == nums.length) {
            return false;
        }
        if (result[index][sum] == null) {
            result[index][sum] =  canPartitionDFS(nums, index + 1, sum - nums[index], target, result) 
            || canPartitionDFS(nums, index + 1, sum, target, result);
        }
        return result[index][sum];
    }
}
