class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 0;
        int suffix = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            suffix = nums[nums.length - 1 - i] * (suffix == 0 ? 1 : suffix);
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}
