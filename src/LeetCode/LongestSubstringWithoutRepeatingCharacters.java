package LeetCode;

public class LongestSubstringWithoutRepeatingCharacters {
    // O(N) time and space. sliding window solution
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> set = new HashSet<>();
            int longestSubstringLength = 0;
            int startIndex = 0;
            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                if (set.contains(a)) {
                    if (set.size() > longestSubstringLength) {
                        longestSubstringLength = set.size();
                    }
                    while (startIndex < s.length() && s.charAt(startIndex) != a) {
                        set.remove(s.charAt(startIndex));
                        startIndex++;
                    }
                    startIndex++;
                } else {
                    set.add(a);
                }

            }
            if (set.size() > longestSubstringLength) {
                longestSubstringLength = set.size();
            }
            return longestSubstringLength;
        }
    }
}
