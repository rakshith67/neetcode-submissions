class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]) == 0 
                ? Integer.compare(a[1], b[1])
                : Integer.compare(a[0], b[0]);
        });
        int result = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start < prevEnd) {
                result++;
                prevEnd = Math.min(prevEnd, end);
                continue;
            }
            prevEnd = end;
        }
        return result;
    }
}
