import LinkedLists.LinkedList;
import LinkedLists.Partition;
import LinkedLists.ReturnKthToLast;
import LinkedLists.SumLists;

public class Main {
    public static void main(String args[]) {
        Integer[] arr1 = {1,2};
        Integer[] arr2 = {1,6};
        LinkedList<Integer> linkedList1 = new LinkedList<>(arr1);
        LinkedList<Integer> linkedList2 = new LinkedList<>(arr2);
        System.out.println(linkedList1);
        System.out.println(linkedList2);
        System.out.println(SumLists.solve(linkedList1, linkedList2));

    }
}
