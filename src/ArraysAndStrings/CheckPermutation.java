package ArraysAndStrings;

public class CheckPermutation {
    public static boolean solve(String first, String second) {
        // check size equal
        // initialize boolean array of ascii size
        // increment the value at array index size for each string
        // decrement the value at array index size for each string
        if (first.length() != second.length()) {
            return false;
        }
        int[] alphabetArr = new int[256];
        for (int i = 0; i < first.length(); i++) {
            int asciiValue = (int) first.charAt(i);
            alphabetArr[asciiValue] += 1;
        }
        for (int i = 0; i < first.length(); i++) {
            int asciiValue = (int) second.charAt(i);
            int value = alphabetArr[asciiValue];
            if (value <= 0) {
                return false;
            }
            alphabetArr[asciiValue] -= 1;
        }
        return true;
    }
}

// Time Complexity: O(N), assuming length of first = length of second
// Space Complexity: O(1), 256 characters for ascii array

// Other alternatives: sort, then use pointers to go through each character
