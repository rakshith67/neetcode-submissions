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
        if (sum > target) {
            return false;
        }
        if (sum == target) {
            return canPartition(nums, index + 1, k - 1, 0, target, used);
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            if (canPartition(nums, i, k, sum + nums[i], target, used)) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }
}