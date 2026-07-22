class Solution {
    public int rob(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int previous = i - 2 >= 0 ? result[i - 2] : 0;
            result[i] = Math.max(nums[i] + previous, result[i - 1]);
        }

        if (nums.length >= 2) {
            return Math.max(result[nums.length - 1], result[nums.length - 2]);
        } else {
            return result[nums.length - 1];
        }
    }
}
