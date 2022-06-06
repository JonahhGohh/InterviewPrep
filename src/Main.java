import LinkedLists.*;
import StacksAndQueues.*;
import TreesAndGraphs.AdjacencyList;
import TreesAndGraphs.*;
import TreesAndGraphs.Node;
import TreesAndGraphs.RouteBetweenNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        Node<Integer> node0 = new Node<>(0);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        Node<Integer> node6 = new Node<>(6);
        Node<Integer> node7 = new Node<>(7);

        node0.setRight(node2);
        node0.setLeft(node1);
        node1.setLeft(node3);
        node1.setRight(node4);
        node3.setLeft(node5);
        node5.setLeft(node6);
        node5.setRight(node7);

        Node<Integer> ansNode = FirstCommonAncestor.solve(node0, node6, node6);
        System.out.println(ansNode);
    }
}
