package RecursionAndDynamicProgramming;

public class RobotInAGrid {
    public static void solve(Integer[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        helper(grid, 0, 0, r, c);
    }

    public static boolean helper(Integer[][] grid, int i, int j, int r, int c) {
        if (i >= r) return false;
        if (j >= c) return false;
        if (i == r - 1 && j == c - 1) {
            grid[i][j] = 9;
            return true;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = 9;
            if (helper(grid, i, j + 1, r, c) || helper(grid, i + 1, j, r, c)) {
                return true;
            } else {
                grid[i][j] = 5;
                return false;
            }
        }
        return false;
    }
}
