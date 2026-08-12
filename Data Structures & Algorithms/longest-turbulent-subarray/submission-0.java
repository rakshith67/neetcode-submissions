class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int count1 = 1;
        int count2 = 1;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 1) {
                if (arr[i] > arr[i - 1]) {
                    count1++;
                    count2 = 1;
                } else if (arr[i] < arr[i - 1]) {
                    count2++;
                    count1 = 1;
                } else {
                    count1 = 1;
                    count2 = 1;
                }
            } else {
                if (arr[i] > arr[i - 1]) {
                    count2++;
                    count1 = 1;
                } else if (arr[i] < arr[i - 1]) {
                    count1++;
                    count2 = 1;
                } else {
                    count1 = 1;
                    count2 = 1;
                }
            }
            System.out.println(i + " " + count1 + " " + count2);
            max = Math.max(max, Math.max(count1, count2));
        }
        return max;   
    }
}