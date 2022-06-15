package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UndirectedWeightedAdjacencyList {
    List<List<Pair>> adjList;
    public UndirectedWeightedAdjacencyList(int numberOfNodes) {
        adjList = new ArrayList<>();
        for (int i = 0; i < numberOfNodes; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void insertEdge(int node1, int node2, int weight) {
        adjList.get(node1).add(new Pair(node2, weight));
        adjList.get(node2).add(new Pair(node1, weight));
    }

    public List<List<Pair>> getAdjList() {
        return adjList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < adjList.size(); i++) {
            List<Pair> lst = adjList.get(i);
            for (int j = 0; j < lst.size(); j++) {
                Pair val = lst.get(j);
                stringBuilder.append(i);
                stringBuilder.append(" -> ");
                stringBuilder.append(val.node);
                stringBuilder.append('(');
                stringBuilder.append(val.weight);
                stringBuilder.append(')');
                if (j != lst.size() - 1) {
                    stringBuilder.append(", ");
                } else {
                    stringBuilder.append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }
}

class Pair {
    public int node;
    public int weight;
    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
