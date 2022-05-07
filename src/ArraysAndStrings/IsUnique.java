package ArraysAndStrings;

/** q1.1: Implement an algorithm to determine if a string has all unique characters. What if you cannot use
 * additional data structures? */
public class IsUnique {
    public static boolean solve(String str) {
        int[] alphabetArr = new int[256];
        for (int i = 0; i < str.length(); i++) {
            int asciiValue = (int) str.charAt(i);
            if (alphabetArr[asciiValue] == 1) {
                return false;
            } else {
                alphabetArr[asciiValue] = 1;
            }
        }
        return true;
    }
}

// Time Complexity: O(N), N: length of str
// Space Complexity: O(1), 26 alphabets
