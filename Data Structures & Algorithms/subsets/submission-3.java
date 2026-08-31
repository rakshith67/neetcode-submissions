class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        fillDFS(nums, new ArrayList<>(), result, -1);
        return result;
    }

    private void fillDFS(int[] nums, List<Integer> currentList, List<List<Integer>> result, int index) {
        if (index == nums.length) {
            return;
        }
        result.add(new ArrayList<>(currentList));
        for (int i = index + 1; i < nums.length; i++) {
            currentList.add(nums[i]);
            fillDFS(nums, currentList, result, i);
            currentList.remove(currentList.size() - 1);
        }
    }
}
