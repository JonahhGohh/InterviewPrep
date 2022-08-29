package LeetCode;

public class RottingOranges {
    class Solution {
        public int orangesRotting(int[][] grid) {
            // given the matrix
            // bfs for each minute
            // how can we tell if all oranges have been rotten

            // can terminate when bfs ends -> gives us the number of minutes.
            // do a loop through the matrix to see if there are still any fresh oranges left
            int[][] visited = new int[grid.length][grid[0].length];
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0) {
                        grid[i][j] = -3;
                    } else if (grid[i][j] == 1) {
                        grid[i][j] = -2;
                    } else {
                        grid[i][j] = -1;
                    }
                }
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == -1) {
                        grid[i][j] = 0;
                        dfs(grid, i, j, 0);
                        grid[i][j] = -1;
                    }
                }
            }
            // for (int i = 0; i < grid.length; i++) {
            //     for (int j = 0; j < grid[0].length; j++) {
            //         System.out.print(grid[i][j] + " ");
            //     }
            //     System.out.println();
            // }

            int maxDist = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == -2) {
                        return -1;
                    }
                    maxDist = Math.max(maxDist, grid[i][j]);
                }
            }
            return maxDist;
        }

        void dfs(int[][] grid, int x, int y, int dist) {
            // System.out.println("Visited: " + x + ", " + y);
            if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) {
                return;
            }
            if ((grid[x][y] == -1) || grid[x][y] == -3) {
                return;
            }
            if (grid[x][y] != -2 && grid[x][y] < dist) return;
            grid[x][y] = dist;

            dfs(grid, x + 1, y, dist + 1);
            dfs(grid, x - 1, y, dist + 1);
            dfs(grid, x, y + 1, dist + 1);
            dfs(grid, x, y - 1, dist + 1);
        }
    }
}
