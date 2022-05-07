package ArraysAndStrings;

public class OneAway {
    public static boolean solve(String firstStr, String secondStr) {
        // check for equality of string length
        // if length the same, check for replacement
        // if length not the same, check for removal
        if (firstStr.length() == secondStr.length()) {
            return isReplaced(firstStr, secondStr);
        }
        if (firstStr.length() == secondStr.length() + 1) {
            return isRemoved(firstStr, secondStr);
        }
        if (firstStr.length() == secondStr.length() - 1) {
            return isRemoved(secondStr, firstStr);
        }
        return false;
    }

    public static boolean isReplaced(String firstStr, String secondStr) {
        // for loop and go down each letter keep a variable to count num of diff letters
        // if num of diff letters > 1, false, else true
        int diffCount = 0;
        for (int i = 0; i < firstStr.length(); i++) {
            if (firstStr.charAt(i) != secondStr.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isRemoved(String longerStr, String shorterStr) {
        int longerIndex = 0;
        for (int shorterIndex = 0; shorterIndex < shorterStr.length(); shorterIndex++) {
            if (longerStr.charAt(longerIndex) != shorterStr.charAt(shorterIndex)) {
                longerIndex++;
                if (longerStr.charAt(longerIndex) != shorterStr.charAt(shorterIndex)) {
                    return false;
                }
            }
            if (longerIndex - shorterIndex > 1) {
                return false;
            }
            longerIndex++;
        }
        return true;
    }
}

// Time Complexity: O(min(firstStr, secondStr))
// Space Complexity: O(1)
