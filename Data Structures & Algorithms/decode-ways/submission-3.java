class Solution {
    public int numDecodings(String s) {
        int[] result = new int[s.length() + 1];
        result[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                result[i] = 0;
                continue;
            }
            result[i] = result[i + 1];
            if (i + 1 < s.length() && (s.charAt(i) == '1' ||
                    s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                result[i] += result[i + 2];
            }
        }
        return result[0];
    }
}
