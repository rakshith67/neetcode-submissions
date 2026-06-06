class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int index1 = 0;
        int index2 = 0;
        while (index1 < word1.length() && index2 < word2.length()) {
            builder.append(word1.charAt(index1));
            builder.append(word2.charAt(index2));
            index1++;
            index2++;
        }
        while (index1 < word1.length()) {
            builder.append(word1.charAt(index1));
            index1++;
        }
        while (index2 < word2.length()) {
            builder.append(word2.charAt(index2));
            index2++;
        }
        return builder.toString();
    }
}