class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        division(nums, result);
        // prefixPostfixMultiplication(nums, result);
        return result;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
    }

    private static void division(int[] nums, int[] result) {
        int zeroCount = 0;
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (zeroCount == 1) {
                    return;
                }
                zeroCount++;
                zeroIndex = i;
            }
        }
        if (zeroCount > 0) {
            int product = 1;
            for (int i = 0; i < nums.length; i++) {
                if (i != zeroIndex) {
                    product = product * nums[i];
                }
            }
            result[zeroIndex] = product;
        } else {
            int product = 1;
            for (int i = 0; i < nums.length; i++) {
                product = product * nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                result[i] = product / nums[i];
            }
        }
    }

    private static void prefixPostfixMultiplication(int[] nums, int[] result) {
        result[0] = 1;

        // Prefix multiplication
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // postfix multiplication
        int postfix = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = postfix * result[i];
            postfix = postfix * nums[i];
        }
    }
}  
