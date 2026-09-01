class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (String word: wordDict) {
                if (i < word.length()) {
                    continue;
                }
                if (s.substring(i - word.length(), i).equals(word)) {
                    if (result[i - word.length()]) {
                        System.out.println(i);
                        result[i] = true;
                        break;
                    }
                }
            }
        }
        return result[s.length()];
    }
}
