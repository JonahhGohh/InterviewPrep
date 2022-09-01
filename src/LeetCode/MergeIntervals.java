package LeetCode;

public class MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            // for (int i = 0; i < intervals.length; i++) {
            //     System.out.println(intervals[i][0] + " " + intervals[i][1]);
            // }
            int start = 0;
            int next = 1;
            int prevEnd = intervals[start][1];
            List<int[]> lst = new ArrayList<>();

            while (start < intervals.length) {
                if (next < intervals.length && intervals[next][0] <= prevEnd) {
                    prevEnd = Math.max(prevEnd, intervals[next][1]);
                    next = next + 1;
                } else {
                    int[] interval = new int[2];
                    interval[0] = Math.min(intervals[start][0], intervals[next - 1][0]);
                    interval[1] = Math.max(intervals[next - 1][1], prevEnd);
                    lst.add(interval);
                    start = next;
                    if (start < intervals.length) {
                        prevEnd = intervals[start][1];
                    }
                    next = next + 1;
                }
            }
            int[][] finalLst = new int[lst.size()][2];
            for (int i = 0; i < lst.size(); i++) {
                finalLst[i] = lst.get(i);
            }
            return finalLst;
        }
    }
}
