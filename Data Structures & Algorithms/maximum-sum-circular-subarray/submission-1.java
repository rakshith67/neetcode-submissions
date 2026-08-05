class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;
        int currentMax = 0;
        int currentMin = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            currentMin = Math.min(currentMin + nums[i], nums[i]);
            globalMax = Math.max(globalMax, currentMax);
            globalMin = Math.min(globalMin, currentMin);
            sum += nums[i];
        }

        if (globalMax > 0) {
            return Math.max(globalMax, sum - globalMin);
        }
        return globalMax;
    }
}