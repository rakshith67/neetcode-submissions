class Solution {
    public boolean canJumpWithDp(int[] nums) {
        boolean[] result = new boolean[nums.length];
        result[result.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            int maximum = Math.min(nums.length - 1, i + nums[i]);
            if (maximum == nums.length - 1) {
                result[i] = true;
                continue;
            }
            for (int j = i + 1; j <= maximum; j++) {
                if (result[j]) {
                    result[i] = true;
                    break;
                }
            }
        }
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.print(result[i] + " ");
        // }
        return result[0];
    }
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int maximum = Math.min(i + nums[i], nums.length - 1);
            if (maximum >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
}
