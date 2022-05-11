import LinkedLists.*;

public class Main {
    public static void main(String args[]) {
//        Integer[] arr1 = {1,2};
//        Integer[] arr2 = {1,6};
//        LinkedList<Integer> linkedList1 = new LinkedList<>(arr1);
//        LinkedList<Integer> linkedList2 = new LinkedList<>(arr2);
//        System.out.println(linkedList1);
//        System.out.println(linkedList2);
//        System.out.println(SumLists.solve(linkedList1, linkedList2));

        Node<Integer> node3 = new Node<>(3, null);
        Node<Integer> node2 = new Node<>(2, node3);
        Node<Integer> node1 = new Node<>(1, node2);
        Node<Integer> node10 = new Node<>(10, null);
        Node<Integer> node9 = new Node<>(9, node10);
        Node<Integer> node8 = new Node<>(8, node9);
        LinkedList<Integer> linkedList1 = new LinkedList<Integer>(node1);
        LinkedList<Integer> linkedList2 = new LinkedList<Integer>(node2);
        LinkedList<Integer> linkedList3 = new LinkedList<Integer>(node8);
        System.out.println(Intersection.solve(linkedList1, linkedList2) == node2);
        System.out.println(Intersection.solve(linkedList1, linkedList3) == null);

//        Character[] charArr1 = {'a', 'b', 'c', 'b', 'a'};
//        Character[] charArr2 = {'a', 'b', 'b', 'a'};
//        Character[] charArr3 = {'a', 'a', 'a', 'a'};
//        Character[] charArr4 = {'a'};
//        Character[] charArr5 = {'a', 'b', 'c', 'd'};
//        Character[] charArr6 = {};
//        System.out.println(Palindrome.solve(new LinkedList<Character>(charArr1)));
//        System.out.println(Palindrome.solve(new LinkedList<Character>(charArr2)));
//        System.out.println(Palindrome.solve(new LinkedList<Character>(charArr3)));
//        System.out.println(Palindrome.solve(new LinkedList<Character>(charArr4)));
//        System.out.println(Palindrome.solve(new LinkedList<Character>(charArr5)));
//        System.out.println(Palindrome.solve(new LinkedList<Character>(charArr6)));
    }
}
