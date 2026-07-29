class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch= s.charAt(i);
            if (last[ch - 'a'] == -1) {
                last[ch - 'a'] = i;
            }
        }

        int end = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            count++;
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                list.add(count);
                count = 0;
            }
        }
        return list;
    }
}
