class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
		int low = 0;
		int high = nums.length - 1;
        while (low < high) {
            int current = partition(nums, low, high);
            if (current == k) {
                break;
            } else if (current < k) {
                low = current + 1;
            } else {
                high = current - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int low, int high) {
        int index = low - 1;
        for (int i = low; i <= high; i++) {
            if (nums[i] <= nums[high]) {
                index++;
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
        return index;
    }
}
