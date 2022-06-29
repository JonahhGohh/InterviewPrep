package RecursionAndDynamicProgramming;

public class Main {
    public static void main(String[] args) {
        Integer[][] grid = {{0, 0, 0, 1}, {1, 1, 0, 1}, {0, 0, 1, 1}, {0, 0, 0, 0}};
        int row = grid.length;
        int col = grid.length;
        System.out.println("Initial Grid: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j]);
                if (j != col - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        RobotInAGrid.solve(grid);
        System.out.println("\nTraversed Grid: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j]);
                if (j != col - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
