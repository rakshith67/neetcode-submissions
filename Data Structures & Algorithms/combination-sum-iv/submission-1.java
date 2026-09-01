class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] result = new int[target + 1];
        result[0] = 1;
        Arrays.sort(nums);
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    result[i] += result[i - nums[j]];
                } else {
                    break;
                }
            }
        }
        return result[target];
    }
}