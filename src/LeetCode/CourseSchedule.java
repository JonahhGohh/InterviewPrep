package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // transform prerequisites to adjList
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < prerequisites.length; i++) {
                int[] prereq = prerequisites[i];
                int course1 = prereq[0];
                int course2 = prereq[1];
                List<Integer> lst = adjList.get(course1);
                lst.add(course2);
            }
            //use adjList to dfs
            int[] visited = new int[numCourses];
            for (int key = 0; key < numCourses; key++) {
                if (hasCycle(adjList, key, visited)) {
                    return false;
                }
            }
            return true;
        }

        boolean hasCycle(List<List<Integer>> list, int node, int[] visited) {
            if (visited[node] == 1) {
                return false;
            }
            if (visited[node] == -1) {
                return true;
            }
            List<Integer> lst = list.get(node);
            if (lst.size() == 0) {
                visited[node] = 1;
                return false;
            }
            visited[node] = -1;
            boolean isCyclic = false;
            for (Integer i : lst) {
                isCyclic = isCyclic || hasCycle(list, i, visited);
            }
            visited[node] = 1;
            return isCyclic;
        }
    }
}
