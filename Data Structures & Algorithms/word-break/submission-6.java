class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (String word: wordDict) {
               int length = i - word.length(); 
                if (length >= 0 && result[length] && s.substring(i - word.length(), i).equals(word)) {
                    // System.out.println(s.substring(0, i));
                    result[i] = true;
                    break;
                }
            }
        }
        return result[s.length()];
    }

    public boolean wordBreakTD(String s, List<String> wordDict) {
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
