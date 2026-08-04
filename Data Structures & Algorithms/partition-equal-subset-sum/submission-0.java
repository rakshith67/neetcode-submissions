class Solution {
    public boolean canPartition(int[] nums) {
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
