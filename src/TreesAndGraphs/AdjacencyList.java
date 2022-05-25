package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyList {
    List<LinkedList<Integer>> adjacencyList;

    public AdjacencyList(int num) {
        List<LinkedList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            adjacencyList.add(new LinkedList<>());
        }
        this.adjacencyList = adjacencyList;
    }

    public void add(int node1, int node2) {
        adjacencyList.get(node1).add(node2);
    }

    public LinkedList<Integer> get(int node) {
        return adjacencyList.get(node);
    }

    public int size() {
        return adjacencyList.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < adjacencyList.size(); i++) {
            LinkedList<Integer> lst = adjacencyList.get(i);
            for (int j = 0; j < lst.size(); j++) {
                int val = lst.get(j);
                stringBuilder.append(i);
                stringBuilder.append(" -> ");
                stringBuilder.append(val);
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
