package LinkedLists;

import java.util.Queue;

public class Partition {
    public static void solve(LinkedList linkedList, int partition) {
        // Initialize a queue
        // Iterate over the nodes
            // if node.value >= partition
                // insert node reference into queue
            // if queue.length > 0 and node.value < partition
                // poll queue and swap polled node value with current node pos value
                // add current node pos ref back to the queue

        Queue<Node> nodeQueue = new java.util.LinkedList<>();
        Node<Integer> node = linkedList.getHead();

        while (node != null) {
            if (node.getValue() >= partition) {
                nodeQueue.add(node);
            } else if (nodeQueue.size() > 0 && node.getValue() < partition) {
                Node<Integer> oldNode = nodeQueue.poll();
                int oldValue = oldNode.getValue();
                oldNode.setValue(node.getValue());
                node.setValue(oldValue);

                nodeQueue.add(node);
            }
            node = node.getNext();
        }
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N)
