/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int index = find(mountainArr, peak, target);
        if (index != -1) {
            return index;
        }
        return findReverse(mountainArr, peak + 1, target);
    }

    private int findPeak(MountainArray mountainArray) {
        int low = 0;
        int high = mountainArray.length() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mountainArray.get(mid) < mountainArray.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int find(MountainArray mountainArray, int peak, int target) {
        int low = 0;
        int high = peak;
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println(mid);
            if (mountainArray.get(mid) == target) {
                return mid;
            }
            if (mountainArray.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int findReverse(MountainArray mountainArray, int start, int target) {
        int low = start;
        int high = mountainArray.length() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mountainArray.get(mid) == target) {
                return mid;
            }
            if (mountainArray.get(mid) > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}