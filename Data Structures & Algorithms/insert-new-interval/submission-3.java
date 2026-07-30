class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean isInserted = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // System.out.println(interval[0] + " " + interval[1]);
            if (interval[0] > newInterval[0]) {
                if (!isInserted) {
                    if (list.isEmpty()) {
                        list.add(newInterval);
                    } else {
                        comparePrevious(list, newInterval);
                    }
                    i--;
                    isInserted = true;
                } else {
                    comparePrevious(list, interval);
                }
            } else {
                list.add(intervals[i]);
            }
        }
        if (list.isEmpty()) {
            list.add(newInterval);
        } else if (!isInserted) {
            comparePrevious(list, newInterval);
        }
        return list.toArray(new int[list.size()][]);
    }

    private void comparePrevious(List<int[]> list, int[] interval) {
        int[] previous = list.get(list.size() - 1);
        if (interval[0] <= previous[1]) {
            previous[1] = Math.max(previous[1], interval[1]);
        } else {
            list.add(interval);
        }
    }
}
