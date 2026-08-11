class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robNonCircular(nums, 1, nums.length - 1), robNonCircular(nums, 0, nums.length - 2));
    }

    public int robNonCircular(int[] nums, int start, int end) {
        int include = nums[start];
        int exclude = 0;
        for (int i = start + 1; i <= end; i++) {
            int temp = include;
            include = Math.max(include, nums[i] + exclude);
            exclude = temp;
        }
        return Math.max(exclude, include);
    }
}
