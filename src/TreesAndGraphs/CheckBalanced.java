package TreesAndGraphs;

public class CheckBalanced<T> {
    public static <T> boolean isBalanced(BST<T> bst) {
        Node<T> root = bst.root;
        if (root == null) {
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    public static <T> int height(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(1 + height(node.left), 1 + height(node.right));
    }
}
