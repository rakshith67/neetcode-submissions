class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        fillDFS(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void fillDFS(int n, int k, int index, List<Integer> current, List<List<Integer>> result) {
        if (index > n) {
            if (current.size() == k) {
                // System.out.println(current);
                result.add(new ArrayList<>(current));
                return;
            }
            return;
        }

        current.add(index);
        fillDFS(n, k, index + 1, current, result);
        current.remove(current.size() - 1);
        fillDFS(n, k, index + 1, current, result);
    }

}