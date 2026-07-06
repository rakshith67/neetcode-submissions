class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0;
        int start = 0;
        int end = 0;
        int result = Integer.MAX_VALUE;
        while (end < nums.length) {
            currentSum += nums[end];
            if (currentSum >= target) {
                while (start < end && currentSum - nums[start] >= target) {
                    currentSum -= nums[start];
                    start++;
                }
                result = Math.min(result, end - start + 1);
                if (start != nums.length - 1) {
                    currentSum -= nums[start];
                    start++;
                }
            }
            end++;
        }
        if (currentSum >= target) {
            result = Math.min(result, end - start);
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}