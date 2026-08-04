class Solution {
    public boolean canPartition(int[] nums) {
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
    public boolean canPartitionTD(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        return canPartitionDFS(nums, 0, 0, target);
    }

    private boolean canPartitionDFS(int[] nums, int index, int sum, int target) {
        if (sum == target) {
            return true;
        }
        if (sum > target || index == nums.length) {
            return false;
        }
        return canPartitionDFS(nums, index + 1, sum + nums[index], target) 
            || canPartitionDFS(nums, index + 1, sum, target);
    }
}
