/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((interval1, interval2) -> {
            if (Integer.compare(interval1.start, interval2.start) == 0) {
                return Integer.compare(interval1.end, interval2.end);
            } else {
                return Integer.compare(interval1.start, interval2.start);
            }
        });

        List<Integer> list = new ArrayList<>();
        for (Interval interval: intervals) {
            if (list.isEmpty()) {
                list.add(interval.end);
                continue;
            }
            boolean inserted = false;
            for (int i = 0; i < list.size(); i++) {
                if (interval.start >= list.get(i)) {
                    list.set(i, interval.end);
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                System.out.println(interval.start + " " + interval.end);
                list.add(interval.end);
            }
        }
        return list.size();
    }
}
