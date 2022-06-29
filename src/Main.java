// import LinkedLists.*;
import LeetCode.PermutationsBackTracking;
import LeetCode.PermutationsNoDuplicates;
import StacksAndQueues.*;
import TreesAndGraphs.AdjacencyList;
import TreesAndGraphs.*;
import TreesAndGraphs.Node;
import TreesAndGraphs.RouteBetweenNodes;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        int[] nums = {1, 2, 2};
        PermutationsNoDuplicates perm = new PermutationsNoDuplicates();
        List<List<Integer>> lst = perm.permute(nums);
        printListsOfLists(lst);
    }

    public static void printListsOfLists(List<List<Integer>> lst) {
        for (int i = 0; i < lst.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < lst.get(0).size(); j++) {
                System.out.print(lst.get(i).get(j));
                if (j != lst.get(0).size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]\n");
        }
    }
}
