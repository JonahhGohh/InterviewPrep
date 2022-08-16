package LeetCode;

public class LinkedListCycle {
    // 141. Linked List Cycle
    // https://leetcode.com/problems/linked-list-cycle/
    public class Solution {
        public boolean hasCycle(ListNode head) {
            // can use hashmap

            // to maintain constant time, we can alter the value of each node

            // use fast and slow pointer
            ListNode fast = head;
            while (true) {
                if (head == null) {
                    return false;
                }
                if (fast == null) {
                    return false;
                }
                head = head.next;
                fast = fast.next;
                if (fast == null) {
                    return false;
                }
                fast = fast.next;
                if (head == fast) {
                    return true;
                }
            }

        }
    }
}
