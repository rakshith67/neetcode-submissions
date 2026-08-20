class Solution {
    public int candy(int[] ratings) {
        int[] sequence = new int[ratings.length];
        Arrays.fill(sequence, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                sequence[i] = sequence[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                sequence[i] = Math.max(sequence[i], sequence[i + 1] + 1);
            }
        }

        int candy = 0;
        for (int num: sequence) {
            candy += num;
        }
        return candy;
    }
}