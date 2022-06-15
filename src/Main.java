// import LinkedLists.*;
import StacksAndQueues.*;
import TreesAndGraphs.AdjacencyList;
import TreesAndGraphs.*;
import TreesAndGraphs.Node;
import TreesAndGraphs.RouteBetweenNodes;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        UndirectedWeightedAdjacencyList undirectedWeightedAdjacencyList = new UndirectedWeightedAdjacencyList(4);
        undirectedWeightedAdjacencyList.insertEdge(0, 1, 1);
        undirectedWeightedAdjacencyList.insertEdge(1, 0, 1);
        undirectedWeightedAdjacencyList.insertEdge(0, 2, 3);
        undirectedWeightedAdjacencyList.insertEdge(2, 0, 3);
        undirectedWeightedAdjacencyList.insertEdge(1, 2, 2);
        undirectedWeightedAdjacencyList.insertEdge(2, 1, 2);
//        undirectedWeightedAdjacencyList.insertEdge(1, 3, 4);
//        undirectedWeightedAdjacencyList.insertEdge(3, 1, 4);
//        undirectedWeightedAdjacencyList.insertEdge(2, 3, 3);
//        undirectedWeightedAdjacencyList.insertEdge(3, 2, 3);
        System.out.println(Prims.solve(undirectedWeightedAdjacencyList));

    }
}
