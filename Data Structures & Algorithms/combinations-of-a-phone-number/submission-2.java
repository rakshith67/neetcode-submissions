class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        List<char[]> list = new ArrayList<>();
        fillList(list);
        StringBuilder builder = new StringBuilder();
        dfs(digits, 0, list, builder, result);
        return result;
    }

    private void dfs(String digits, int index, List<char[]> list, StringBuilder builder, List<String> result) {
        if (index == digits.length()) {
            result.add(builder.toString());
            return;
        }
        char[] array = list.get(digits.charAt(index) - '0');
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            dfs(digits, index + 1, list, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    private void fillList(List<char[]> list) {
        list.add(new char[0]);
        list.add(new char[0]);
        list.add(new char[] {'a', 'b', 'c'});
        list.add(new char[] {'d', 'e', 'f'});
        list.add(new char[] {'g', 'h', 'i'});
        list.add(new char[] {'j', 'k', 'l'});
        list.add(new char[] {'m', 'n', 'o'});
        list.add(new char[] {'p', 'q', 'r', 's'});
        list.add(new char[] {'t', 'u', 'v'});
        list.add(new char[] {'w', 'x', 'y', 'z'});

    }
}
