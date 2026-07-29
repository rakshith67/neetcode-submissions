class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            }
        }

        int end = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            count++;
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end) {
                list.add(count);
                count = 0;
            }
        }
        return list;
    }
}
