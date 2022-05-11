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

        Character[] charArr1 = {'a', 'b', 'c', 'b', 'a'};
        Character[] charArr2 = {'a', 'b', 'b', 'a'};
        Character[] charArr3 = {'a', 'a', 'a', 'a'};
        Character[] charArr4 = {'a'};
        Character[] charArr5 = {'a', 'b', 'c', 'd'};
        Character[] charArr6 = {};
        System.out.println(Palindrome.solve(new LinkedList<Character>(charArr1)));
        System.out.println(Palindrome.solve(new LinkedList<Character>(charArr2)));
        System.out.println(Palindrome.solve(new LinkedList<Character>(charArr3)));
        System.out.println(Palindrome.solve(new LinkedList<Character>(charArr4)));
        System.out.println(Palindrome.solve(new LinkedList<Character>(charArr5)));
        System.out.println(Palindrome.solve(new LinkedList<Character>(charArr6)));
    }
}
