class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            int startChar;
            int endChar;
            if (start < end && !isAlphabet(s.charAt(start)) && !isNumber(s.charAt(start))) {
                start++;
                continue;
            }
            if (end > start && !isAlphabet(s.charAt(end)) && !isNumber(s.charAt(end))) {
                end--;
                continue;
            }
            if (isNumber(s.charAt(start)) || isNumber(s.charAt(end))) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
                continue;
            }
            if (s.charAt(start) != s.charAt(end) && s.charAt(start) != s.charAt(end) + 32
            && s.charAt(start) != s.charAt(end) - 32) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isAlphabet(char character) {
        return (character >= 'A' && character <= 'Z')
        || (character >= 'a' && character <= 'z');
    }

    private boolean isNumber(char character) {
        return character >= '0' && character <= '9';
    }
}
