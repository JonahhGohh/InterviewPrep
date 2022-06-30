package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> solve(List<Integer> lst) {
        List<List<Integer>> finalLst = new ArrayList<>();
        finalLst.add(new ArrayList<>());
        for (int i = 0; i < lst.size(); i++) {
            int currSetSize = finalLst.size();
            for (int j = 0; j < currSetSize; j++) {
                List<Integer> newLst = copyList(finalLst.get(j));
                newLst.add(lst.get(i));
                finalLst.add(newLst);
            }
        }
        return finalLst;
    }

    public static List<Integer> copyList(List<Integer> lst) {
        List<Integer> newLst = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            newLst.add(lst.get(i));
        }
        return newLst;
    }

    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(1, 2, 3);
        List<List<Integer> > finalLst = solve(lst);
        for (int i = 0; i < finalLst.size(); i++) {
            System.out.println(finalLst.get(i).toString());
        }
    }
}
