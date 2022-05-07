package ArraysAndStrings;

import java.util.HashMap;

public class PalindromePermutation {
    public static boolean solve(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        String parsedString = str.toLowerCase();
        for (int i = 0; i < parsedString.length(); i++) {
            char character = parsedString.charAt(i);
            if (character == ' ') {
                continue;
            }
            if (hashMap.containsKey(character)) {
                hashMap.put(character, hashMap.get(character) + 1);
            } else {
                hashMap.put(character, 1);
            }
        }
        int singleCount = 0;
        for (int value : hashMap.values()) {
            if (value % 2 != 0) {
                singleCount++;
            }
        }
        if (singleCount > 1) {
            return false;
        }
        return true;
    }
}

// Time complexity: O(N), N: length of str
// Space complexity: O(N)
