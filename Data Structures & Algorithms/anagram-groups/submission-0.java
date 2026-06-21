class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] temp = new String(strs[i]).toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);
            if (map.get(sorted) == null) {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(strs[i]);
                map.put(sorted, anagrams);
            } else {
                map.get(sorted).add(strs[i]);
            }
        }

        List<List<String>> result = new ArrayList();

        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
