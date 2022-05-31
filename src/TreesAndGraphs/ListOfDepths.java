package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepths<T> {
    public static <T> List<LinkedList<T>> createLinkedLists(BST<T> bst) {
        List<LinkedList<T>> list = new ArrayList<>();
        createLinkedListsHelper(list, bst.root, 0);
        return list;
    }

    private static <T> void createLinkedListsHelper(List<LinkedList<T>> list, Node<T> node, int level) {
        if (node != null) {
            if (list.size() <= level) {
                LinkedList<T> linkedList = new LinkedList<>();
                linkedList.add(node.value);
                list.add(linkedList);
            } else {
                list.get(level).add(node.value);
            }
            createLinkedListsHelper(list, node.left, level + 1);
            createLinkedListsHelper(list, node.right, level + 1);
        }
    }

    public static <T> void printListOfDepths(List<LinkedList<T>> list) {
        for (int i = 0; i < list.size(); i++) {
            LinkedList<T> ll = list.get(i);
            System.out.print("[");
            Iterator it = ll.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + ", ");
            }
            System.out.print("]");
        }
    }
}
