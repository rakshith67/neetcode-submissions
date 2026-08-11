class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int[] result = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            result[i] = 1 + result[i - 1];
            for (String word: dictionary) {
                if (i - word.length() < 0) {
                    continue;
                }
                if (s.substring(i - word.length(), i).equals(word)) {
                    // System.out.println(i + " " + s.substring(i - word.length(), i));
                    result[i] = Math.min(result[i], result[i - word.length()]);
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        return result[s.length()];
    }
}