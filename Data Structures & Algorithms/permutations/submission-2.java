class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> currentList) {
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            currentList.add(nums[i]);
            used[i] = true;
            dfs(nums, used, currentList);
            currentList.remove(currentList.size() - 1);
            used[i] = false;
        }
    }
}
