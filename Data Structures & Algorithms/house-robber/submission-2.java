class Solution {
    public int rob(int[] nums) {
        int include = nums[0];
        int exclude = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = include;
            include = Math.max(include, nums[i] + exclude);
            exclude = temp;
        }
        return Math.max(exclude, include);
    }
}
