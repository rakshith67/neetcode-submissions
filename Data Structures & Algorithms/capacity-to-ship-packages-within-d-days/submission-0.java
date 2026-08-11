class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < weights.length; i++) {
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        int result = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canShip(weights, mid, days)) {
                high = mid - 1;
                result = mid;
            } else {
                low = mid + 1; 
            }
        }
        return result;
    }

    private boolean canShip(int[] weights, int maxCapacity, int days) {
        int currentWeight = 0;
        int numberOfDays = 1;
        for (int i = 0; i < weights.length; i++) {
            int sum = currentWeight + weights[i];
            if (sum > maxCapacity) {
                numberOfDays++;
                currentWeight = weights[i];
            } else {
                currentWeight = sum;
            }
        }
        return numberOfDays <= days;
    }
}