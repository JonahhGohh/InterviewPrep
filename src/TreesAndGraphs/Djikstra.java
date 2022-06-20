package TreesAndGraphs;

import java.util.*;

public class Djikstra {
    public static void main(String[] args) {
        int V = 9;
        List<List<NodePair>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        int source = 0;
        graph.get(0).add(new NodePair(1, 4));
        graph.get(0).add(new NodePair(7, 8));
        graph.get(1).add(new NodePair(2, 8));
        graph.get(1).add(new NodePair(7, 11));
        graph.get(1).add(new NodePair(0, 7));
        graph.get(2).add(new NodePair(1, 8));
        graph.get(2).add(new NodePair(3, 7));
        graph.get(2).add(new NodePair(8, 2));
        graph.get(2).add(new NodePair(5, 4));
        graph.get(3).add(new NodePair(2, 7));
        graph.get(3).add(new NodePair(4, 9));
        graph.get(3).add(new NodePair(5, 14));
        graph.get(4).add(new NodePair(3, 9));
        graph.get(4).add(new NodePair(5, 10));
        graph.get(5).add(new NodePair(4, 10));
        graph.get(5).add(new NodePair(6, 2));
        graph.get(6).add(new NodePair(5, 2));
        graph.get(6).add(new NodePair(7, 1));
        graph.get(6).add(new NodePair(8, 6));
        graph.get(7).add(new NodePair(0, 8));
        graph.get(7).add(new NodePair(1, 11));
        graph.get(7).add(new NodePair(6, 1));
        graph.get(7).add(new NodePair(8, 7));
        graph.get(8).add(new NodePair(2, 2));
        graph.get(8).add(new NodePair(6, 6));
        graph.get(8).add(new NodePair(7, 1));

        int[] distance = solve(graph, source);
        // Printing the Output
        System.out.println("Vertex  "
                + "  Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "             "
                    + distance[i]);
        }
    }

    public static int[] solve(List<List<NodePair>> adjList, int startNode) {
        // initialize visited arr
        boolean visited[] = new boolean[adjList.size()];
        // initialize empty pq
        PriorityQueue<NodePair> pq = new PriorityQueue(new Comparator<NodePair>() {
            @Override
            public int compare(NodePair o1, NodePair o2) {
                return o1.getDistance() - o2.getDistance();
            }
        });

        int[] distanceTable = new int[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            if (i == startNode) {
                distanceTable[i] = 0;
            } else {
                distanceTable[i] = Integer.MAX_VALUE;
            }
        }

        pq.add(new NodePair(startNode, 0));
        visited[startNode] = true;

        while (!pq.isEmpty()) {
            NodePair nodePair = pq.poll();
            int node = nodePair.getNode();

            List<NodePair> edges = adjList.get(nodePair.getNode());

            for (NodePair edge : edges) {
                if (visited[edge.getNode()]) continue;
                int newDistance = distanceTable[node] + edge.getDistance();
                if (newDistance < distanceTable[edge.getNode()]) {
                    distanceTable[edge.getNode()] = newDistance;
                    pq.add(new NodePair(edge.getNode(), newDistance));
                }
            }
        }
        return distanceTable;
    }

}

class NodePair {
    int node;
    int distance;

    NodePair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    int getNode() {
        return node;
    }

    int getDistance() {
        return distance;
    }
}
