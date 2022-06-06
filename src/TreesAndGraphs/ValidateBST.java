package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {
    public static boolean solve(BST<Integer> bst) {
        OrderCheckerList orderCheckerList = new OrderCheckerList();
        inOrder(bst.root, orderCheckerList);
        return orderCheckerList.isOrdered;
    }

    public static void inOrder(Node<Integer> node, OrderCheckerList orderCheckerList) {
        if (node != null) {
            inOrder(node.left, orderCheckerList);
            orderCheckerList.add(node.value);
            inOrder(node.right, orderCheckerList);
        }
    }
}

class OrderCheckerList {
    List<Integer> list;
    boolean isOrdered;

    OrderCheckerList() {
        list = new ArrayList<>();
        isOrdered = true;
    }

    void add(Integer curr) {
        System.out.println(curr);
        if (list.size() == 0) {
            list.add(curr);
        } else {
            int prev = list.get(list.size() - 1);
            if (prev > curr) {
                isOrdered = false;
            }
            list.add(curr);
        }
    }
}
