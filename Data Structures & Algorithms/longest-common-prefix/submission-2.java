class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder builder = new StringBuilder();
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minimum) {
                minimum = strs[i].length();
            }
        }
        char current;
        for (int i = 0; i < minimum; i++) {
            current = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != current) {
                    return builder.toString();
                }
            }
            builder.append(current);
        }
        return builder.toString();
    }
}