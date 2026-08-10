class Solution {
    public int integerBreak2(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int result = 1;
        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        return result * n;
    }

    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int divisor = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, divisor);
        } else if (remainder == 1) {
            return (int) Math.pow(3, divisor - 1) * 4;
        } else {
            return (int) Math.pow(3, divisor) * 2;
        }
    }
}