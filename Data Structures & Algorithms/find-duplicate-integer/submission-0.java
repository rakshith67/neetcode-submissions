class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current < 0) {
                current = -current;
            }
            if (nums[current] < 0) {
                return current;
            }
            nums[current] = -nums[current];
        }
        return -1;
    }
}
