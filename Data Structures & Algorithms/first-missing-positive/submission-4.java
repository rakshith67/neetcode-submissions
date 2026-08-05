class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int current = Math.abs(nums[i]);
            if (current == 0 || current > nums.length) {
                continue;
            }
            if (nums[current - 1] > 0) {
                nums[current - 1] *= -1;
            } else if (nums[current - 1] == 0) {
                nums[current - 1] = -1 * (nums.length + 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}