class Solution {

    class Pair{
        String word;
        int distance;
        Pair(String word, int distance){
            this.word = word;
            this.distance = distance;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        set.add(beginWord);
        if(!set.contains(endWord)) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        set.remove(beginWord);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String word = current.word;
            if (word.equals(endWord)) { 
                return current.distance;
            }
            char[] array = word.toCharArray();

            for (int i = 0; i < array.length; i++) {
                char ch = array[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (ch == c) {
                        continue;
                    }
                    array[i] = c;
                    String s = new String(array);
                    if (set.contains(s)) {
                        set.remove(s);
                        queue.offer(new Pair(s, current.distance + 1));
                    }
                }
                array[i] = ch;
            }
        }
        return 0;
    }
}
