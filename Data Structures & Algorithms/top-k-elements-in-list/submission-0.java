class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] frequency = new List[nums.length + 1];
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (frequency[entry.getValue()] == null) {
                frequency[entry.getValue()] = new ArrayList<>();
            }
            frequency[entry.getValue()].add(entry.getKey());
        }

        int[] topK = new int[k];
        int index = 0;
        for (int i = nums.length; i > 0; i--) {
            if (frequency[i] != null) {
                for (Integer number: frequency[i]) {
                    if (index == k) {
                        break;
                    }
                    topK[index++] = number;
                }
            }
        }

        return topK;
    }
}
