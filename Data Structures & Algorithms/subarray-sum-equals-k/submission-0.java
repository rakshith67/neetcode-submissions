class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int totalSum = 0;
        int count = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            int diff = totalSum - k;
            count += map.getOrDefault(diff , 0);;
            map.put(totalSum, map.getOrDefault(totalSum, 0) + 1);
        }
        return count;
    }
}