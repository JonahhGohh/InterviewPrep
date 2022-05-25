package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RouteBetweenNodes {
    public static boolean solve(AdjacencyList adjacencyList, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjacencyList.size()];

        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == end) {
                return true;
            }
            LinkedList<Integer> nodeList = adjacencyList.get(node);
            for (int nextNode : nodeList) {
                if (!visited[nextNode]) {
                    visited[node] = true;
                    queue.add(nextNode);
                }
            }
        }
        return false;
    }
}
