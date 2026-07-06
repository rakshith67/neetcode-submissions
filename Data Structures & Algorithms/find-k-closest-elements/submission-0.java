class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = findIndex(arr, x);
        System.out.println(index);
        int left = index - 1;
        int right = index;
        int count = 0;
        while (left >= 0 || right < arr.length) {
            if (count == k) {
                break;
            }
            if (left >= 0 && right < arr.length) {
                if (Math.abs(x - arr[left]) <= Math.abs(arr[right] - x)) {
                    left--;
                } else {
                    right++;
                }
            } else if (left >= 0) {
                left--;
            } else {
                right++;
            }
            count++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    private int findIndex(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}