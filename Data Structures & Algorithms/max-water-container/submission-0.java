class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;
        int currentArea;
        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            currentArea = height * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
