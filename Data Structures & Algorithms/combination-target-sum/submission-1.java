class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        fillDFS(nums, 0, target, new ArrayList<>());
        return result;
    }

    private void fillDFS(int[] nums, int index, int target, List<Integer> currentList) {     
        if (target < 0 || index == nums.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            target -= nums[i];
            currentList.add(nums[i]);
            fillDFS(nums, i, target, currentList);
            target += nums[i];
            currentList.remove(currentList.size() - 1);
        }
    }
}
