class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            int left = map.getOrDefault(nums[i] - 1, 0);
            int right = map.getOrDefault(nums[i] + 1, 0);
            int sequence = 1 + left + right;
            map.put(nums[i], sequence);
            map.put(nums[i] - map.getOrDefault(nums[i] - 1, 0), sequence);
            map.put(nums[i] + map.getOrDefault(nums[i] + 1, 0), sequence);
            max = Math.max(sequence, max);
        }
        return max;
    }
}
