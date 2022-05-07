package ArraysAndStrings;

public class StringCompression {
    public static String solve(String str) {
        // declare 2 variables: currentLetter, currentCount
        // declare StringBuilder variable that builds the String
        // loop through str
        // append letter and count to string builder when letter changes
        // reset letter to new letter and count to 0
        // at the end, check if original string length > compressed string length
        // return appropriate result
        if (str.length() < 1) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char currentLetter = str.charAt(0);
        int currentCount = 1;
        for (int i = 1; i < str.length(); i++) {
            if (currentLetter == str.charAt(i)) {
                currentCount++;
            } else {
                stringBuilder.append(currentLetter);
                stringBuilder.append(currentCount);
                currentLetter = str.charAt(i);
                currentCount = 1;
            }
        }
        stringBuilder.append(currentLetter);
        stringBuilder.append(currentCount);
        String compressedString = stringBuilder.toString();
        return str.length() > compressedString.length() ? compressedString : str;
    }
}

// Time complexity: O(length of str)
// Space complexity: O(length of str) -> From StringBuilder
