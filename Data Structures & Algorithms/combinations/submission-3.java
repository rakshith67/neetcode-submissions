class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        dfs(n, k, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int n, int k, int index, List<Integer> currentList) {
        if (currentList.size() == k) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = index + 1; i <= n; i++) {
            currentList.add(i);
            dfs(n, k, i, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }
}