class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        fillDFS(candidates, -1, target, new ArrayList<>());
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
        for (int i = index + 1; i < nums.length; i++) {
            target -= nums[i];
            currentList.add(nums[i]);
            fillDFS(nums, i, target, currentList);
            target += nums[i];
            currentList.remove(currentList.size() - 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
    }
}
