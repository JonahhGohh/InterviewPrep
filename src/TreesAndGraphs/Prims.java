package TreesAndGraphs;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {
    public static UndirectedWeightedAdjacencyList solve(UndirectedWeightedAdjacencyList undirectedAdjList) {
        List<List<Pair>> adjList = undirectedAdjList.getAdjList();
        UndirectedWeightedAdjacencyList ans = new UndirectedWeightedAdjacencyList(adjList.size());
        helper(ans, adjList);
        return ans;
    }

    public static void helper(UndirectedWeightedAdjacencyList ans, List<List<Pair>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        PriorityQueue<Triplet> pq = new PriorityQueue<>(new Comparator<Triplet>() {
            @Override
            public int compare(Triplet o1, Triplet o2) {
                return o1.weight - o2.weight;
            }
        });

        List<Pair> nodeZeroEdges = adjList.get(0);
        visited[0] = true;
        int numVisited = 1;
        for (Pair pair : nodeZeroEdges) {
            pq.add(new Triplet(0, pair.node, pair.weight));
        }

        while (!pq.isEmpty() && numVisited != adjList.size()) {
            Triplet triplet = pq.poll();
            if (visited[triplet.end] == true) {
                continue;
            }
            visited[triplet.end] = true;
            numVisited++;
            ans.insertEdge(triplet.start, triplet.end, triplet.weight);
            List<Pair> currNodeEdges = adjList.get(triplet.end);

            for (Pair pair : currNodeEdges) {
                if (visited[pair.node] == false) {
                    pq.add(new Triplet(triplet.end, pair.node, pair.weight));
                }
            }
        }
        if (numVisited != adjList.size()) {
            System.out.println("MST does not exist. Forests exist");
        }
    }
}

class Triplet {
    int start;
    int end;
    int weight;

    public Triplet(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}
