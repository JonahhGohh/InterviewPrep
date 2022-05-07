package ArraysAndStrings;

public class RotateMatrix {
    public static boolean solve(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        int n = matrix.length - 1;
        int left = 0;
        int right = n;

        while (right > left) {
            for (int j = left; j < right; j++) {
                int temp = matrix[left][j];
                matrix[left][j] = matrix[n - j][left];
                matrix[n - j][left] = matrix[n - left][n - j];
                matrix[n - left][n - j] = matrix[j][n - left];
                matrix[j][n - left] = temp;
            }
            right--;
            left++;
        }
        return true;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
