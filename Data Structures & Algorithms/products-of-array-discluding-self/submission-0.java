class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
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

        return result;
    }
}  
