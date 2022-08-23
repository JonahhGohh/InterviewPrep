package LeetCode;

public class KClosestPointsToOrigin {
    class Solution {
        // O(nlogk)
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> dist(b) - dist(a));

            for (int[] p : points) {
                pq.add(p);
                if (pq.size() > k) pq.remove();
            }

            return pq.toArray(new int[k][2]);
        }

        private int dist(int[] p) {
            return p[0] * p[0] + p[1] * p[1];
        }

    }
}
