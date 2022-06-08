package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BSTSequences {
    public static void solve(BST<Integer> bst) {
        Node<Integer> root = bst.root;
        List<LinkedList<Integer>> finalList = bstSequences(root);
        printResult(finalList);
    }

    public static List<LinkedList<Integer>> bstSequences(Node<Integer> node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<LinkedList<Integer>> leftArrOfArr = bstSequences(node.left);
        List<LinkedList<Integer>> rightArrOfArr = bstSequences(node.right);

        List<LinkedList<Integer>> permutedArrOfArr = permute(leftArrOfArr, rightArrOfArr);

        addFirstForAll(permutedArrOfArr, node.value);
        return permutedArrOfArr;
    }

    public static void addFirstForAll(List<LinkedList<Integer>> lst, int val) {
        for (int i = 0; i < lst.size(); i++) {
            LinkedList<Integer> ll = lst.get(i);
            ll.addFirst(val);
        }
    }

    public static List<LinkedList<Integer>> permute(List<LinkedList<Integer>> left, List<LinkedList<Integer>> right) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        if (left.size() == 0 && right.size() == 0) {
            result.add(new LinkedList<>());
            return result;
        } else if (left.size() == 0) {
            return right;
        } else if (right.size() == 0) {
            return left;
        }

        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < right.size(); j++) {
                permuteInOrder(left.get(i), right.get(j), result, new LinkedList<>());
            }
        }
        return result;
    }
    public static void permuteInOrder(LinkedList<Integer> lst1, LinkedList<Integer> lst2, List<LinkedList<Integer>> result, LinkedList<Integer> prefix) {
        // BASE CASE:  if either list is length 0 can just append the rest to the back
        if (lst1.size() == 0 || lst2.size() == 0) {
            LinkedList<Integer> linkedList = (LinkedList<Integer>) prefix.clone();
            linkedList.addAll(lst1);
            linkedList.addAll(lst2);
            result.add(linkedList);
            return;
        }
        // RECURSIVE CASE: pick from lst1 or pick from lst2 and recurse

        // pick from lst1
        int val1 = lst1.removeFirst();
        prefix.addLast(val1);
        permuteInOrder(lst1, lst2, result, prefix);
        prefix.removeLast();
        lst1.addFirst(val1);

        // pick from lst2
        int val2 = lst2.removeFirst();
        prefix.addLast(val2);
        permuteInOrder(lst1, lst2, result, prefix);
        prefix.removeLast();
        lst2.addFirst(val2);

        // at each call stack in the recursion, the same lst1, lst2 and prefix linkedlist is being used throughout
        // this is why it is important to removeLast() / addFirst() back to restore the linkedlist at each call stack

//        // pick from lst1
//        LinkedList<Integer> linkedList1 = (LinkedList<Integer>) lst1.clone();
//        LinkedList<Integer> prefix1 = (LinkedList<Integer>) prefix.clone();
//        int val1 = linkedList1.removeFirst();
//        prefix1.addLast(val1);
//        permuteInOrder(linkedList1, lst2, result, prefix1);
//
//        // pick from lst2
//        LinkedList<Integer> linkedList2 = (LinkedList<Integer>) lst2.clone();
//        LinkedList<Integer> prefix2 = (LinkedList<Integer>) prefix.clone();
//        int val2 = linkedList2.removeFirst();
//        prefix2.addLast(val2);
//        permuteInOrder(lst1, linkedList2, result, prefix2);
    }

    public static void printResult(List<LinkedList<Integer>> result) {
        for (int i = 0; i < result.size(); i++) {
            LinkedList<Integer> linkedList = result.get(i);
            Iterator<Integer> iterator = linkedList.iterator();
            System.out.print("[");
            while (iterator.hasNext()) {
                int val = iterator.next();
                System.out.print(val + ", ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}

// Time complexity: V * 2^V
