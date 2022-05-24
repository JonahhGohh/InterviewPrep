package LinkedLists;

public class Intersection {
    public static <T> Node<T> solve(LinkedList<T> linkedList1, LinkedList<T> linkedList2) {
        // remember the reference head of both linkedlist
        // because one linkedlist has to be a subset of another
        // move down the linkedlist for both and check if either is equal to any of both heads
        // return null if no intersection when either linkedlist node is null

        int length1 = getLength(linkedList1);
        int length2 = getLength(linkedList2);
        if (length1 > length2) {
            chopLength(linkedList1, length1 - length2);
        } else {
            chopLength(linkedList2, length2 - length1);
        }
        Node<T> node1 = linkedList1.getHead();
        Node<T> node2 = linkedList2.getHead();

        while (node1 != null) {
            if (node1 == node2) {
                return node1;
            }
            node1 = node1.getNext();
            node2= node2.getNext();
        }

        return null;
    }

    static <T> int getLength(LinkedList<T> linkedList) {
        Node<T> node = linkedList.getHead();
        int length = 0;
        while (node != null) {
            length++;
            node = node.getNext();
        }
        return length;
    }

    static <T> void chopLength(LinkedList<T> linkedList, int lengthToChop) {
        Node<T> node = linkedList.getHead();
        while (lengthToChop > 0 && node != null) {
            node = node.getNext();
            lengthToChop--;
        }
        linkedList.setHead(node);
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N)
