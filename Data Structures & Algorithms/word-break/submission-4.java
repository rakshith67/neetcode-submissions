class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int start = 0;
        Boolean[] result = new Boolean[s.length()];
        return canBreakDFS(s, wordDict, result, start);
    }

    private boolean canBreakDFS(String s, List<String> wordDict, Boolean[] result, int start) {
        if (start == s.length()) {
            return true;
        }
        if (result[start] == null) {
            for (String word : wordDict) {
                if (s.startsWith(word, start) && canBreakDFS(s, wordDict, result, start + word.length())) {
                    result[start] = true;
                    return true;
                }
            }
        }
        result[start] = false;
        return result[start];
    }
}
