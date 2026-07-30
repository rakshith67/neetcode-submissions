class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(intervals[i][0] + " " + intervals[i][1]);
        }
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] previous = list.get(list.size() - 1);
            if (intervals[i][0] == previous[0]) {
                previous[1] = Math.max(intervals[i][1], previous[1]);
                continue;
            }
            if (intervals[i][0] <= previous[1]) {
                previous[1] = Math.max(intervals[i][1], previous[1]);
                continue;
            }
            if (intervals[i][0] > previous[1]) {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
