package TreesAndGraphs;

public class Successor<Integer> {
    public static <Integer> NodeWithParent<Integer> solve(NodeWithParent<Integer> node) {
        // got right child
        if (node.right != null) {
            NodeWithParent<Integer> leftChild = node.right;
            while (leftChild.left != null)  {
                leftChild = leftChild.left;
            }
            return leftChild;
        } else {
            NodeWithParent<Integer> parent = node.parent;
            while (parent != null) {
                if ((int) parent.value > (int) node.value) {
                    return parent;
                }
                parent = parent.parent;
            }
            return null;
        }
    }
}
