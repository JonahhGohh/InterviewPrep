package LinkedLists;

public class ReturnKthToLast {
    public static <T> LinkedList<T> solve(LinkedList<T> linkedList, int k) {
        Node<T> head = linkedList.getHead();
        while (head != null && k > 0) {
            head = head.getNext();
            k--;
        }
        return new LinkedList<>(head);
    }
}
