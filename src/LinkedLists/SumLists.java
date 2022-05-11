package LinkedLists;

public class SumLists {
    public static LinkedList<Integer> solve(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        return new LinkedList<Integer>(helper(list1.getHead(), list2.getHead()));
    }

    public static Node<Integer> helper(Node<Integer> head1, Node<Integer> head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        Node<Integer> oldNode;
        if (head1 == null && head2 != null) {
            oldNode = helper(null, head2.getNext());
        } else if (head1 != null && head2 == null) {
            oldNode = helper(head1.getNext(), null);
        } else {
            oldNode = helper(head1.getNext(), head2.getNext());
        }
        if (oldNode == null) {
            return new Node<>(head1.getValue() + head2.getValue(), null);
        } else {
            int totalValue = head1.getValue() + head2.getValue();
            int oldNodeValue = oldNode.getValue();
            int actualOldNodeValue = oldNodeValue % 10;
            int carry = oldNodeValue > 9 ? 1 : 0;
            oldNode.setValue(actualOldNodeValue);
            return new Node<>(totalValue + carry, oldNode);
        }
    }
}
