class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        int leftAdded = 0;
        int rightAdded = 0;
        List<String> list = new ArrayList<>();
        dfs(n, 0, builder, leftAdded, rightAdded, list);
        return list;
    }

    private void dfs(int n, int index, StringBuilder builder, int leftAdded, int rightAdded, List<String> list) {
        if (index == 2 * n) {
            list.add(builder.toString());
            return;
        }

        if (leftAdded == 0) {
            builder.append('(');
            leftAdded++;
            dfs(n, index + 1, builder, leftAdded, rightAdded, list);
        } else {
            if (leftAdded < n) {
                builder.append('(');
                leftAdded++;
                dfs(n, index + 1, builder, leftAdded, rightAdded, list);
                leftAdded--;
                builder.deleteCharAt(builder.length() - 1);
            }
            if (rightAdded < n && leftAdded > rightAdded) {
                builder.append(')');
                rightAdded++;
                dfs(n, index + 1, builder, leftAdded, rightAdded, list);
                builder.deleteCharAt(builder.length() - 1);
                rightAdded--;
            }
        }
    }
}
