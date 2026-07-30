class Solution {
    public boolean checkInclusion(String s1, String s2) {
         if (s2.length() < s1.length()) {
            return false;
        }
        int[] count = new int[26];
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            count[s1.charAt(i)- 'a']++;
        }

        int start = 0;
        int[] current = new int[26];
        int end = 0;
        while (end < length - 1) {
            current[s2.charAt(end) - 'a']++;
            end++;
        }
        while (end < s2.length()) {
            current[s2.charAt(end) - 'a']++;
            if (isEqual(count, current)) {
                return true;
            }
            current[s2.charAt(start) - 'a']--;
            start++;
            end++;
        }
        return false;
    }

    private boolean isEqual(int[] num1, int[] num2) {
        // for(int i = 0; i < num1.length; i++) {
        //     System.out.print(num1[i] + "");
        // }
        // System.out.println();
        //  for(int i = 0; i < num1.length; i++) {
        //     System.out.print(num2[i] + "");
        // }
        // System.out.println();
        for (int i = 0; i < 26; i++) {
            if (num1[i] != num2[i]) {
                return false;
            }
        }
        return true;
    }
}
