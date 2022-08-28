package LeetCode;

public class ImplementTrie {
    class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node currNode = root;
            for (int i = 0; i < word.length(); i++) {
                char w = word.charAt(i);
                int charIndex = w - 'a';
                if (currNode.arr[charIndex] == null) {
                    Node newNode = new Node();
                    currNode.arr[charIndex] = newNode;
                }
                currNode = currNode.arr[charIndex];

            }
            currNode.isEnd = true;
        }

        public boolean search(String word) {
            Node currNode = root;
            for (int i = 0; i < word.length(); i++) {
                char w = word.charAt(i);
                Node nextNode = currNode.arr[w - 'a'];
                if (nextNode == null) {
                    return false;
                }
                currNode = nextNode;
            }
            return currNode.isEnd;
        }

        public boolean startsWith(String prefix) {
            Node currNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                char w = prefix.charAt(i);
                Node nextNode = currNode.arr[w - 'a'];
                if (nextNode == null) {
                    return false;
                }
                currNode = nextNode;
            }
            return true;
        }
    }

    class Node {
        public Node[] arr = new Node[26];
        public boolean isEnd;

        public Node() {
            isEnd = false;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
