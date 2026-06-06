class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int end = 0;
        int index = 0;
        while (start <= end && end < nums.length) {
            while (end < nums.length && nums[start] == nums[end]) {
                end++;
            }
            if (start < nums.length) {
                nums[index++] = nums[start];
            }
            start = end;
        }
        return index;
    }
}