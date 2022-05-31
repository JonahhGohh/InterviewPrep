package TreesAndGraphs;

public class BST<T> {
    public Node<T> root;

    public BST(Node<T> root) {
        this.root = root;
    }

    public void printBST() {
        printBSTHelper(root);
    }

    private void printBSTHelper(Node<T> node) {
        if (node != null) {
            printBSTHelper(node.left);
            System.out.println(node);
            printBSTHelper(node.right);
        }
    }

}
