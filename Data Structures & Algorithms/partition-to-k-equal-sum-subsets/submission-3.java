class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
        boolean[] used = new boolean[nums.length];
        return canPartition(nums, 0, k, 0, sum / k, used);
    }

    private boolean canPartition(int[] nums, int index, int k, int sum, int target, boolean[] used) {
        if (k == 0) {
            return true;
        }
        if (sum == target) {
            return canPartition(nums, 0, k - 1, 0, target, used);
        }
        for (int i = index; i < nums.length; i++) {
            if (used[i] || sum + nums[i] > target) {
                continue;
            }
            used[i] = true;
            if (canPartition(nums, i + 1, k, sum + nums[i], target, used)) {
                return true;
            }
            used[i] = false;
            if (sum == 0) {
                break;
            }
        }
        return false;
    }
}