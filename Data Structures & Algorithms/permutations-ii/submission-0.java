class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new LinkedList<>(), list, new boolean[nums.length]);
        return list;
    }

    private void dfs(int[] nums, List<Integer> current, List<List<Integer>> list, boolean[] visited) {
        if (current.size() == nums.length) {
            list.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            current.add(nums[i]);
            dfs(nums, current, list, visited);
            current.remove(current.size() - 1);
            visited[i] = false;
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
    }
}