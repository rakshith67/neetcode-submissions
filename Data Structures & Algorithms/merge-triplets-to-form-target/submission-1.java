class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean first = false;
        boolean second = false;
        boolean third = false;
        for (int i = 0; i < triplets.length; i++) {
            if (!first && triplets[i][0] == target[0]) {
                if (triplets[i][1] > target[1] || triplets[i][2] > target[2]) {
                    first = false;
                } else {
                    first = true;
                }
            }
            if (!second && triplets[i][1] == target[1]) {
                if (triplets[i][0] > target[0] || triplets[i][2] > target[2]) {
                    second = false;
                } else {
                    second = true;
                }
            }
            if (!third && triplets[i][2] == target[2]) {
                if (triplets[i][1] > target[1] || triplets[i][0] > target[0]) {
                    third = false;
                } else {
                    third = true;
                }
            }
        }
        return first && second && third;
    }
}
