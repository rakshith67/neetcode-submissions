class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int result = 0;
        int start = 0;
        int end = 0;
        int[] count = new int[128];
        while (end < s.length()) {
           char ch = s.charAt(end);
            if (count[ch] == 1) {
                result = Math.max(result, end - start);
                while (s.charAt(start) != ch) {
                    count[s.charAt(start)] = 0;
                    start++;
                }
                count[s.charAt(start)] = 0;
                start++;
            }
            count[ch] = 1;
            end++;
        }
        return Math.max(result, end - start);
    }
}
