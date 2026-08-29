class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int num: nums) {
            low = Math.max(low, num);
            high += num;
        }

        int result = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canSplit(nums, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private boolean canSplit(int[] nums, int k, int targetSum) {
        int count = 1;
        int sum = 0;
        for (int num: nums) {
            sum += num;
            if (sum > targetSum) {
                count++;
                if (count > k) {
                    return false;
                }
                sum = num;
            }
        }
        return true;
    }
}