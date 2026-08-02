class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        for(int i = 0; i < s.length(); i++) {
            populateCount(s, i, i); //odd palindromes
            populateCount(s, i, i + 1); // even palindromes
        }
        return count;
    }

    private void populateCount(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            count++;
        }
    }
}
