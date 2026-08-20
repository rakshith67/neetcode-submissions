class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = nums1.length + nums2.length;
        int globalMid = (total + 1) / 2;
        int low = 0;
        int high = nums1.length;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = globalMid - mid1;

            int left1 = mid1 - 1 >= 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int left2 = mid2 - 1 >= 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int right1 = mid1 < nums1.length ? nums1[mid1] : Integer.MAX_VALUE;
            int right2 = mid2 < nums2.length ? nums2[mid2] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if (total % 2 != 0) {
                    return (double) Math.max(left1, left2);
                }
                return (double) (Math.max(left1, left2) + Math.min(right1, right2)) / 2 ;
            } else if (left1 > right2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return -1;
    }
}
