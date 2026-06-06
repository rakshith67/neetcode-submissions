class Solution {
    public int calPoints(String[] operations) {
        int[] record = new int[operations.length];
        int index = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].charAt(0) == 'C') {
                record[index - 1] = 0;
                index--;
            } else if (operations[i].charAt(0) == 'D') {
                record[index] = 2 * record[index - 1];
                index++;
            } else if (operations[i].charAt(0) == '+') {
                record[index] = record[index - 1] + record[index - 2];
                index++;
            } else {
                record[index++] = Integer.valueOf(operations[i]);
            }
        }
        int totalScore = 0;
        for (int i = 0; i < record.length; i++) {
            totalScore += record[i];
        }
        return totalScore;
    }
}