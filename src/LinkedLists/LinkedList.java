package LinkedLists;

public class LinkedList<T> {
    Node<T> head;

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public LinkedList(T[] arr) {
        Node<T> node = new Node<>(arr[arr.length - 1], null);
        for (int i = arr.length - 2; i >= 0; i--) {
            Node<T> newNode = new Node<>(arr[i], null);
            newNode.setNext(node);
            node = newNode;
        }
        head = node;
    }

    public Node<T> getHead() {
        return head;
    }

    /** Returns true if node is deleted successfully, false otherwise */
    public boolean deleteNode(int index) {
        Node<T> prevNode = null;
        Node<T> node = head;
        if (index == 0) {
            head = head.getNext();
            return true;
        }
        while (index > 0 && node != null) {
            prevNode = node;
            node = node.getNext();
            index--;
        }
        if (node == null && index > 0) {
            return false;
        }
        prevNode.setNext(node.getNext());
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = head;
        while (node != null) {
            String val = node.getValue().toString();
            stringBuilder.append(val);
            stringBuilder.append(" -> ");
            node = node.getNext();
        }
        int stringLength = stringBuilder.length();
        if (stringLength > 4) {
            stringBuilder.delete(stringLength - 4, stringLength);
        }
        return stringBuilder.toString();
    }
}
