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
                        int[] previous = list.get(list.size() - 1);
                        if (newInterval[0] <= previous[1]) {
                            previous[1] = Math.max(previous[1], newInterval[1]);
                        } else {
                            list.add(newInterval);
                        }
                    }
                    i--;
                    isInserted = true;
                } else {
                    int[] previous = list.get(list.size() - 1);
                    if (interval[0] <= previous[1]) {
                        previous[1] = Math.max(previous[1], interval[1]);
                    } else {
                        list.add(interval);
                    }
                }
            } else {
                list.add(intervals[i]);
            }
        }
        if (list.isEmpty()) {
            list.add(newInterval);
        } else if (!isInserted) {
            int[] previous = list.get(list.size() - 1);
            if (newInterval[0] <= previous[1]) {
                previous[1] = Math.max(previous[1], newInterval[1]);
            } else {
                list.add(newInterval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
