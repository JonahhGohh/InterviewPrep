// import LinkedLists.*;
import StacksAndQueues.*;
import TreesAndGraphs.AdjacencyList;
import TreesAndGraphs.*;
import TreesAndGraphs.Node;
import TreesAndGraphs.RouteBetweenNodes;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node7 = new Node<>(7);
        node5.setLeft(node3);
        node5.setRight(node7);
        node3.setLeft(node2);
        node3.setRight(node4);
        node7.setLeft(node6);
        node2.setLeft(node1);
        BST<Integer> T1 = new BST<>(node5);

        Node<Integer> node6copy = new Node<>(6);
        Node<Integer> node7copy = new Node<>(7);
        node7copy.setLeft(node6copy);
        BST<Integer> T2 = new BST<>(node7copy);

        System.out.println(CheckSubtree.solveMatchTree(T1, T2));

    }
}
