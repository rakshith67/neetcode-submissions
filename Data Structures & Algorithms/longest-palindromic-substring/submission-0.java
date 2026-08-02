class Solution {
    int start = -1;
    int maxLength = 0;
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            populateStartAndMaxLength(s, i, i); //Odd length palindromes
            populateStartAndMaxLength(s, i, i + 1); //Even length palindromes
        }
        return s.substring(start, start + maxLength);
    }

    private void populateStartAndMaxLength(String s, int startIndex, int endIndex) {
        while (startIndex >= 0 && endIndex < s.length() && s.charAt(startIndex) == s.charAt(endIndex)) {
            startIndex--;
            endIndex++;
        }

        if (endIndex - startIndex - 1 > maxLength) {
            start = startIndex + 1;
            maxLength = endIndex - startIndex - 1;
        }
    }
}
