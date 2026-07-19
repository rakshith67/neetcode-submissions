class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        fillDFS(nums, target, 0, new ArrayList<>(), result, 0);
        return result;
    }

    private void fillDFS(int[] nums, int target, int currentSum, List<Integer> currentList, List<List<Integer>> result, int index) {
        if (currentSum == target) {
            System.out.println(currentList);
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum > target) {
                currentSum -= nums[i];
                break;
            }

            // System.out.println(nums[i] + " " + currentSum);
            currentList.add(nums[i]);
            fillDFS(nums, target, currentSum, currentList, result, i);
            currentList.remove(currentList.size() - 1);
            currentSum -= nums[i];
        }
    }
}
