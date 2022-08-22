package LeetCode;

public class ZeroOneMatrix {
    // 542. 01 Matrix
    // https://leetcode.com/problems/01-matrix/
    class Solution {
        public int[][] updateMatrix(int[][] mat) {
            int iLength = mat.length;
            int jLength = mat[0].length;
            for (int i = 0; i < iLength; i++) {
                for (int j = 0; j < jLength; j++) {
                    if (mat[i][j] == 1) {
                        mat[i][j] = 20000;
                    }
                }
            }
            for (int i = 0; i < iLength; i++) {
                for (int j = 0; j < jLength; j++) {
                    int val = mat[i][j];
                    if (val == 0) {
                        continue;
                    }
                    int min = getMinForward(mat, i, j, iLength, jLength);
                    mat[i][j] = min;
                }
            }
            for (int i = iLength - 1; i >= 0; i--) {
                for (int j = jLength - 1; j >= 0; j--) {
                    int val = mat[i][j];
                    if (val == 0) {
                        continue;
                    }
                    int min = getMinBackward(mat, i, j, iLength, jLength);
                    mat[i][j] = min;
                }
            }
            return mat;
        }

        int getMinForward(int[][] mat, int i, int j, int iLength, int jLength) {
            int top = 30000;
            int left = 30000;
            // top
            if (i - 1 >= 0) {
                top = mat[i - 1][j];
            }
            // left
            if (j - 1 >= 0) {
                left = mat[i][j - 1];
            }
            return Math.min(Math.min(top, left) + 1, mat[i][j]);
        }

        int getMinBackward(int[][] mat, int i, int j, int iLength, int jLength) {
            int right = 30000;
            int bottom = 30000;
            // right
            if (j + 1 < jLength) {
                right = mat[i][j + 1];
            }
            // bottom
            if (i + 1 < iLength) {
                bottom = mat[i + 1][j];
            }
            return Math.min(Math.min(right, bottom) + 1, mat[i][j]);
        }
    }
}
