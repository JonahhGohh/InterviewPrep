package LinkedLists;

public class Reverse {
    public static <T> void reverseIter(LinkedList<T> linkedList) {
        Node<T> prev = null;
        Node<T> curr = linkedList.getHead();
        while (curr != null) {
            Node<T> next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        linkedList.setHead(prev);
    }

    public static <T> void reverseRecurHead(LinkedList<T> linkedList) {
        linkedList.setHead(recurHeadHelper(null, linkedList.getHead()));
    }

    private static <T> Node<T> recurHeadHelper(Node<T> prev, Node<T> curr) {
        if (curr == null) return prev;
        Node<T> next = curr.getNext();
        curr.setNext(prev);
        return recurHeadHelper(curr, next);
    }

    public static <T> void reverseRecurTail(LinkedList<T> linkedList) {
        linkedList.setHead(recurTailHelper(null, linkedList.getHead()));
    }

    private static <T> Node<T> recurTailHelper(Node<T> prev, Node<T> curr) {
        if (curr == null) return prev;
        Node<T> newHead = recurTailHelper(curr, curr.getNext());
        curr.setNext(prev);
        return newHead;
    }
}
