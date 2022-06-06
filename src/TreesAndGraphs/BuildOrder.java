package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuildOrder {
    // Time Complexity: O(V + E)
    public static List<Integer> solve(List<List<Integer>> adjList) {
        int size = adjList.size();
        boolean visited[] = new boolean[size];
        int insertPosition = size - 1;
        List<Integer> topoSorted = initArrayList(size);


        for (int i = 0; i < size; i++) {
            if (visited[i] == false) {
                insertPosition = dfs(visited, insertPosition, adjList, i, topoSorted);
            }
        }
        return topoSorted;
    }

    private static int dfs(boolean visited[], int insertPosition, List<List<Integer>> adjList, int node, List<Integer> topoSorted) {
        visited[node] = true;
        for (int otherNode : adjList.get(node)) {
            if (visited[otherNode] == false) {
                insertPosition = dfs(visited, insertPosition, adjList, otherNode, topoSorted);
            }
        }
        topoSorted.set(insertPosition, node);
        return insertPosition - 1;
    }

    private static List<Integer> initArrayList(int size) {
        List<Integer> lst = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            lst.add(-1);
        }
        return lst;
    }

    // Time Complexity: O(V + E)
    public static List<Integer> solveWithKahn(List<List<Integer>> adjList) {
        int[] inDegree = new int[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();

        // initialize inDegree
        for (List<Integer> edges : adjList) {
            for (int vertex : edges) {
                inDegree[vertex] = inDegree[vertex] + 1;
            }
        }

        for (int i : inDegree) {
            if (i == 0) {
                queue.add(i);
            }
        }

        List<Integer> buildOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            buildOrder.add(vertex);
            List<Integer> edges = adjList.get(vertex);
            for (int i : edges) {
                int degree = inDegree[i];
                if (degree == 1) {
                    queue.add(i);
                }
                inDegree[i] = degree - 1;
            }
        }
        if (buildOrder.size() != adjList.size()) {
            return null;
        }
        return buildOrder;
    }
}
