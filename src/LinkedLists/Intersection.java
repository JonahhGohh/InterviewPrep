package LinkedLists;

public class Intersection {
    public static <T> Node<T> solve(LinkedList<T> linkedList1, LinkedList<T> linkedList2) {
        // remember the reference head of both linkedlist
        // because one linkedlist has to be a subset of another
        // move down the linkedlist for both and check if either is equal to any of both heads
        // return null if no intersection when either linkedlist node is null
        Node<T> head1 = linkedList1.getHead();
        Node<T> head2 = linkedList2.getHead();

        Node<T> node1 = linkedList1.getHead();
        Node<T> node2 = linkedList2.getHead();

        while (node1 != null && node2 != null) {
            if (node1 == head2) {
                return node1;
            }
            if (node2 == head1) {
                return node2;
            }
            node1 = node1.getNext();
            node2 = node2.getNext();
        }

        return null;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N)
