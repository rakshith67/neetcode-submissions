class Solution {
    public int jumpDp(int[] nums) {
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

    public int jump(int[] nums) {
        int low = 0;
        int high = 0;
        int count = 0;
        while (high < nums.length - 1) {
            int farthest = 0;
            for (int i = low; i <= high; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            count++;
            high = farthest;
            low++;
        }
        return count;
    }
}
