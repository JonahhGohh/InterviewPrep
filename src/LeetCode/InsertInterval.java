package LeetCode;

public class InsertInterval {
    // 57. Insert Interval
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> lst = new ArrayList<>();
            for (int[] interval : intervals) {
                if (newInterval == null || interval[1] < newInterval[0]) {
                    lst.add(interval);
                } else if (newInterval[1] < interval[0]) {
                    lst.add(newInterval);
                    lst.add(interval);
                    newInterval = null;
                } else {
                    newInterval[0] = Math.min(interval[0], newInterval[0]);
                    newInterval[1] = Math.max(interval[1], newInterval[1]);
                }
            }

            if (newInterval != null) {
                lst.add(newInterval);
            }
            return lst.toArray(new int[0][0]);
        }
    }
}
