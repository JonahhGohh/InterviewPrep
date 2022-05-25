import LinkedLists.*;
import StacksAndQueues.*;
import TreesAndGraphs.AdjacencyList;
import TreesAndGraphs.RouteBetweenNodes;

public class Main {
    public static void main(String args[]) {
        AdjacencyList adjacencyList = new AdjacencyList(5);
        adjacencyList.add(0, 1);
        adjacencyList.add(0, 2);
        adjacencyList.add(1, 2);
        adjacencyList.add(1, 4);
        System.out.println(adjacencyList);

        System.out.println(RouteBetweenNodes.solve(adjacencyList, 0, 0));
        System.out.println(RouteBetweenNodes.solve(adjacencyList, 0, 1));
        System.out.println(RouteBetweenNodes.solve(adjacencyList, 0, 2));
        System.out.println(RouteBetweenNodes.solve(adjacencyList, 0, 3));
        System.out.println(RouteBetweenNodes.solve(adjacencyList, 0, 4));
        System.out.println(RouteBetweenNodes.solve(adjacencyList, 1, 1));
        System.out.println(RouteBetweenNodes.solve(adjacencyList, 1, 2));
        System.out.println(RouteBetweenNodes.solve(adjacencyList, 1, 3));
        System.out.println(RouteBetweenNodes.solve(adjacencyList, 1, 4));
    }
}
