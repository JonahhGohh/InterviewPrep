package LinkedLists;

import java.util.Deque;

public class Palindrome {
    public static boolean solve(LinkedList<Character> linkedList) {
        // initialise deque
        // loop through linkedlist and addLast to deque
        // condition of while deque.length > 1
            // remove first and remove last and check for equality
            // return false if just one equality check fails
        // return true
        Deque<Character> deque = new java.util.LinkedList<>();
        Node<Character> node = linkedList.getHead();

        while (node != null) {
            deque.addLast(node.getValue());
            node = node.getNext();
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N)
