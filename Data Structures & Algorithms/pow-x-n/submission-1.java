class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        double result = 1;
        long power = Math.abs((long)n);

        while (power > 0) {
            if ((power & 1) == 1) { // If odd multiply with number
                result *= x;
            }
            x *= x;
            power >>= 1; // Divide by 2
        }
        return n >= 0 ? result : 1 / result;
    }
}
