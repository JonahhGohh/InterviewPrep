import LinkedLists.*;
import StacksAndQueues.*;
import TreesAndGraphs.AdjacencyList;
import TreesAndGraphs.*;
import TreesAndGraphs.Node;
import TreesAndGraphs.RouteBetweenNodes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        Node<Integer> node0 = new Node<>(0);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        node0.setLeft(node1);
        node1.setLeft(node2);
        node0.setRight(node3);
//        Node<Integer> node1 = new Node<>(1);
//        Node<Integer> node0 = new Node<>(0);
//        Node<Integer> node1 = new Node<>(1);
        BST<Integer> bst = new BST<>(null);
        System.out.println(CheckBalanced.isBalanced(bst));
    }
}
