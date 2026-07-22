class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robNonCircular(nums, 1, nums.length), robNonCircular(nums, 0, nums.length - 1));
    }

    public int robNonCircular(int[] nums, int start, int end) {
        int[] result = new int[end];
        result[start] = nums[start];

        for (int i = start + 1; i < end; i++) {
            int previous = i - 2 >= 0 ? result[i - 2] : 0;
            result[i] = Math.max(nums[i] + previous, result[i - 1]);
        }

        if (end >= 2) {
            return Math.max(result[end - 1], result[end - 2]);
        } else {
            return result[end - 1];
        }
    }
}
