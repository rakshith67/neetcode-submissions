class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] result = new int[nums.length];
        result[result.length - 1] = 0;
        Arrays.fill(result, 100000);
        for (int i = nums.length - 2; i >= 0; i--) {
            int maximum = Math.min(nums.length - 1, i + nums[i]);
            if (maximum == nums.length - 1) {
                result[i] = 1;
                continue;
            }
            for (int j = i + 1; j <= maximum; j++) {
                result[i] = Math.min(result[i], 1 + result[j]);
            }
        }
        // for (int i = 0; i < nums.length; i++) {
        //     System.out.print(result[i] + " ");
        // }
        return result[0];
    }
}
