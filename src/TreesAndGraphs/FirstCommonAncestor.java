package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class FirstCommonAncestor<T> {
    public static <T> Node<T> solve(Node<T> root, Node<T> firstNode, Node<T> secondNode) {
        List<Node<T>> lst = new ArrayList<>(1);
        helper(root, firstNode, secondNode, lst);
        return lst.get(0);
    }

    public static <T> boolean helper(Node<T> node, Node<T> firstNode, Node<T> secondNode, List<Node<T>> lst) {
        if (node == null) {
            return false;
        } else if (node.equals(firstNode) && node.equals(secondNode)) {
            lst.add(node);
            return false;
        }
        boolean leftTree = helper(node.left, firstNode, secondNode, lst);
        boolean rightTree = helper(node.right, firstNode, secondNode, lst);

        boolean b = node.equals(firstNode) || node.equals(secondNode);
        if ((leftTree && b) || (rightTree && b) || (leftTree && rightTree)) {
            lst.add(node);
            return false;
        } else if (b) {
            return true;
        }
        return leftTree || rightTree;
    }
}
