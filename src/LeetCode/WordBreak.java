package LeetCode;

public class WordBreak {
    // https://leetcode.com/problems/word-break
    public boolean wordBreak(String s, List<String> wordDict) {
        // build trie
        if (s.length() <= 0) {
            return true;
        }

        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }

        HashMap<String, Boolean> map = new HashMap<>();

        return wordBreakHelper(s, trie, map);
    }

    public boolean wordBreakHelper(String s, Trie trie, Map<String, Boolean> map) {
        if (s.length() == 0)
            return true;
        if (map.containsKey(s)) {
            return map.get(s);
        }
        // we use result variable here because each recursion split is 1 possible combination
        // to break s. there can be multiple ways to break s up, so we chain it with ||.
        boolean result = false;
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            strBuilder.append(s.charAt(i));
            int exists = trie.search(strBuilder.toString());
            if (exists == 1) {
                result = wordBreakHelper(s.substring(i + 1), trie, map) || result;
            } else if (exists == -1) {
                map.put(s, false);
                result = result || false;
                break;
            }

        }
        map.put(s, result);
        return result;
    }

    class Trie {
        static final int ALPHABET_SIZE = 26;
        TrieNode root;

        class TrieNode {
            TrieNode[] children = new TrieNode[ALPHABET_SIZE];
            boolean isEndOfWord;

            TrieNode() {
                isEndOfWord = false;
                for (int i = 0; i < children.length; i++) {
                    children[i] = null;
                }
            }
        }

        Trie() {
            this.root = new TrieNode();
        }

        void insert(String key) {
            TrieNode curr = root;
            for (int i = 0; i < key.length(); i++) {
                int character = key.charAt(i);
                int index = character - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.isEndOfWord = true;
        }

        int search(String key) {
            TrieNode curr = root;
            for (int i = 0; i < key.length(); i++) {
                int character = key.charAt(i);
                int index = character - 'a';
                if (curr.children[index] == null) {
                    return -1;
                }
                curr = curr.children[index];
            }
            return curr.isEndOfWord ? 1 : 0;
        }

    }
}
