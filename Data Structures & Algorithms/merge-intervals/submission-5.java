class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] previous = list.get(list.size() - 1);
            if (previous[1] >= intervals[i][0]) {
                previous[1] = Math.max(previous[1], intervals[i][1]);
                continue;
            }
            list.add(intervals[i]);
        }
        return list.toArray(new int[list.size()][]);
    }
}
