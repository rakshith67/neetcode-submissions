class Solution {
    public boolean hasDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        Map<Integer, Boolean> duplicates = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (duplicates.get(nums[i]) != null) {
                return true;
            }
            duplicates.put(nums[i], true);
        }
        return false;
    }
}