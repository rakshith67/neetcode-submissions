class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int partitionIndex = partition(nums, low, high);
            if (partitionIndex == k) {
                break;
            } else if (partitionIndex < k) {
                low = partitionIndex + 1;
            } else {
                high = partitionIndex - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int index = low - 1;
        for (int i = low; i <= high; i++) {
            if (nums[i] <= pivot) {
                index++;
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
        }
        return index;
    }
}
