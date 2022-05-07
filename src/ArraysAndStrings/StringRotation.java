package ArraysAndStrings;

public class StringRotation {
    public static boolean solve(String original, String rotated) {
        if (original.length() != rotated.length()) {
            return false;
        }
        String doubleRotated = rotated + rotated;
        return doubleRotated.contains(original);
    }
}

// Time complexity: O(N)
// Space complexity: O(N)

