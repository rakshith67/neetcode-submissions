class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        int previous = 0;
        int start = 0;
        int[][] result = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(result[i], - 1);
        }
        return canBreakDFS(s, set, result, previous, start);
    }

    private boolean canBreakDFS(String s, Set<String> set, int[][] result, int previous, int start) {
        if (start == s.length()) {
            String current = s.substring(previous, start);
            // System.out.println(current);
            if (set.contains(current)) {
                return true;
            }
            return false;
        }
        if (result[previous][start] != -1) {
            return result[previous][start] == 0 ? false : true;
        }
        if (set.contains(s.substring(previous, start))) {
            // System.out.println(s.substring(previous, start));
            result[previous][start] = (canBreakDFS(s, set, result, start, start + 1) 
                                        || canBreakDFS(s, set,  result, previous, start + 1))
                                        == false ? 0 : 1;
        } else {
            result[previous][start] = canBreakDFS(s, set, result, previous, start + 1) == false ? 0 : 1;
        }
        return result[previous][start] == 0 ? false : true;
    }
}
