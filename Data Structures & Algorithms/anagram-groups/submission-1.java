class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            int[] count = new int[26];
            for(int j = 0; j < strs[i].length(); j++) {
                count[strs[i].charAt(j) - 'a']++;
            }
            String anagram = Arrays.toString(count);
            result.putIfAbsent(anagram, new ArrayList<>());
            result.get(anagram).add(strs[i]);
        }
        return new ArrayList<>(result.values());
    }
}
