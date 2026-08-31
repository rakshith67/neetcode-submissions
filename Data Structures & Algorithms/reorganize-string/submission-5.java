class Solution {

    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                queue.offer(new int[] {i, count[i]});
            }
        }

        int[] prev = null;
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            builder.append((char) ('a' + current[0]));
            
            if (prev != null) {
                queue.offer(prev);
            }

            if (current[1] == 1) {
                prev = null;
            } else {
                current[1]--;
                prev = current;
            }
        }

        return prev == null ? builder.toString() : "";
    }

    public String reorganizeString2(String s) {
        int[] count = new int[26];
        int max = 0;
        char maxChar = ' ';
        int maxIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            if (count[s.charAt(i) - 'a'] > max) {
                max = count[s.charAt(i) - 'a'];
                maxChar = s.charAt(i);
                maxIndex = s.charAt(i) - 'a';
            }
        }
        // System.out.println(max + " " + maxIndex + " " + maxChar);
        if (max > (s.length() + 1) / 2) {
            return "";
        }
        char[] result = new char[s.length()];
        int index = 0;
        while (count[maxIndex] > 0) {
            result[index] = maxChar;
            index += 2;
            count[maxIndex]--;
        }
        // System.out.println(count[maxIndex]);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                while (count[i] > 0) {
                    if (index >= s.length()) {
                        index = 1;
                    }
                    result[index] = (char) (i + 'a');
                    index += 2;
                    count[i]--;
                }
            }
        }
        return String.valueOf(result);
    }

    class Frequency implements Comparable<Frequency> {
        char ch;
        int frequency;

        public Frequency(char ch, int frequency) {
            this.ch = ch;
            this.frequency = frequency;
        }

        public int compareTo(Frequency freq) {
            return freq.frequency - frequency;
        }
    }
}