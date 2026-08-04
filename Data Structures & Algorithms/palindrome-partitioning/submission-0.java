class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        fillResultDFS(s, 0, 0, result, new ArrayList<>());
        return result;
    }

    private void fillResultDFS(String s, int start, int end, List<List<String>> result, List<String> current) {
        if (end == s.length()) {
            if (start == end) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        if (isPalindrome(s, start, end)) {
            current.add(s.substring(start, end + 1));
            fillResultDFS(s, end + 1, end + 1, result, current);
            current.remove(current.size() - 1);
        }
        fillResultDFS(s, start, end + 1, result, current);
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
