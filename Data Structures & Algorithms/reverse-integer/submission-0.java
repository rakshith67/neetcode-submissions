class Solution {
    public int reverse(int x) {
        long integer = x;
        boolean isNegative = false;
        if (integer < 0) {
            isNegative = true;
            integer = -(integer);
        }

        long sum = 0;
        while (integer > 0) {
            sum = sum * 10 + (integer % 10);
            integer /= 10;
        }

        if (isNegative) {
            sum = -sum;
        } 

        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return 0;
        }
        int result = (int) sum;
        return result;
    }
}
