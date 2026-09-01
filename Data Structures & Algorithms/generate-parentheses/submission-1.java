class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        List<String> list = new ArrayList<>();
        dfs(n, builder, 0, 0, list);
        return list;
    }

    private void dfs(int n, StringBuilder builder, int left, int right, List<String> list) {
        if (left == n && right == n) {
            list.add(new String(builder.toString()));
            return;
        }

        if (left < n) {
            builder.append('(');
            left++;
            dfs(n, builder, left, right, list);
            left--;
            builder.deleteCharAt(builder.length() - 1);
        }

        if (left > right && right < n) {
            builder.append(')');
            right++;
            dfs(n, builder, left, right, list);
            right--;
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
