import LinkedLists.LinkedList;
import LinkedLists.ReturnKthToLast;

public class Main {
    public static void main(String args[]) {
        Integer[] arr = {1,2,3,4,5};
        LinkedList<Integer> linkedList = new LinkedList<>(arr);
        System.out.println(linkedList);
        System.out.println(linkedList.deleteNode(4));
        System.out.println(linkedList);
    }
}
