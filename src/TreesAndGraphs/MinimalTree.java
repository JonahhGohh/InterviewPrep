package TreesAndGraphs;

import java.util.List;

public class MinimalTree {
    public static <T> BST<T> buildBinarySearchTree(List<T> list) {
        return new BST(buildBinarySearchTreeHelper(list, 0, list.size() - 1));
    }

    private static <T> Node<T> buildBinarySearchTreeHelper(List<T> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        Node<T> node = new Node(list.get(middle));
        node.setLeft(buildBinarySearchTreeHelper(list, left, middle - 1));
        node.setRight(buildBinarySearchTreeHelper(list, middle + 1, right));
        return node;
    }
}
