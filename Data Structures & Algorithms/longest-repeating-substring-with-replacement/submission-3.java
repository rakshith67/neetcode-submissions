class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequency = new int[26];
        int start = 0;
        int end = 0;
        int max = 0;
        int maxCount = 0;
        while (end < s.length()) {
            frequency[s.charAt(end) - 'A']++;
            if (maxCount < frequency[s.charAt(end) - 'A']) {
                maxCount = frequency[s.charAt(end) - 'A'];
            }
            if (end - start + 1 - maxCount > k) {
                frequency[s.charAt(start) - 'A']--;
                start++;
            } else {
                max = Math.max(max, end - start + 1);
            }
            end++;
        }
        return max;
    }
}
