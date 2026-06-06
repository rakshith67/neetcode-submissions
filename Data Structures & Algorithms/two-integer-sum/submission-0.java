class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> previousMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (previousMap.containsKey(target - nums[i])) {
                return new int[]{previousMap.get(target - nums[i]), i};
            }
            previousMap.put(nums[i], i);
        }
        return new int[2];
    }
}
