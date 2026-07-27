class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        boolean hasPositive = false;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] >= 0) {
                hasPositive = true;
            }
        }
        if (!hasPositive) {
            return max;
        }
        int sum = 0;
        max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            System.out.println(sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
