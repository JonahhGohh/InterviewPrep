package TreesAndGraphs;

public class CheckSubtree {
    public static boolean solve(BST<Integer> T1, BST<Integer> T2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        buildString(T1.root, stringBuilder1);
        buildString(T2.root, stringBuilder2);
        String value1 = stringBuilder1.toString();
        String value2 = stringBuilder2.toString();
        return value1.contains(value2);
    }

    public static void buildString(Node<Integer> node, StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append('n');
        } else {
            stringBuilder.append(node.value);
            buildString(node.left, stringBuilder);
            buildString(node.right, stringBuilder);
        }
    }

    public static boolean solveMatchTree(BST<Integer> T1, BST<Integer> T2) {
        return T2.root == null ? true : helper(T1.root, T2.root);
    }

    public static boolean helper(Node<Integer> node1, Node<Integer> root2) {
        if (node1 == null) {
            return false;
        }
        if (node1.value == root2.value && matchTree(node1, root2)) {
            return true;
        }

        return helper(node1.left, root2) || helper(node1.right, root2);
    }

    public static boolean matchTree(Node<Integer> node1, Node<Integer> node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else if (node1.value != node2.value) {
            return false;
        } else {
            return matchTree(node1.left, node2.left) && matchTree(node1.right, node2.right);
        }
    }

}
