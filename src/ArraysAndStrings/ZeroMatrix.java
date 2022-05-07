package ArraysAndStrings;

import java.util.HashSet;
import java.util.Iterator;

public class ZeroMatrix {
    public static void solve(int[][] matrix) {
        // initialize x coordinate hash set
        // initialize y coordinate hash set
        // double loop over x and y, if value at coordinate = 0, add x value and y value to respective hash set

        // iterate over though each coordinate hash set and paint the values 0
        if (matrix.length == 0) {
            return;
        }
        int xLength = matrix.length;
        int yLength = matrix[0].length;

        HashSet<Integer> xSet = new HashSet<>();
        HashSet<Integer> ySet = new HashSet<>();

        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (matrix[i][j] == 0) {
                    xSet.add(i);
                    ySet.add(j);
                }
            }
        }

        Iterator<Integer> xIterator = xSet.iterator();
        while (xIterator.hasNext()) {
            int xValue = xIterator.next();
            for (int i = 0; i < yLength; i++) {
                matrix[xValue][i] = 0;
            }
        }

        Iterator<Integer> yIterator = ySet.iterator();
        while (yIterator.hasNext()) {
            int yValue = yIterator.next();
            for (int i = 0; i < xLength; i++) {
                matrix[i][yValue] = 0;
            }
        }
    }
}

// Time complexity: O(M*N)
// Space complexity: O(M+N)
// if you data structure is going to be overidden with new values, you might be able to use
// it as storage for some information.
