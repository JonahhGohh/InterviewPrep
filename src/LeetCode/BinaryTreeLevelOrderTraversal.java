package LeetCode;

public class BinaryTreeLevelOrderTraversal {
    // 102. Binary Tree Level Order Traversal
    // O(N) time and space solution
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lst = new ArrayList<>();
            levelOrderHelper(root, lst, 0);
            return lst;
        }

        public void levelOrderHelper(TreeNode root, List<List<Integer>> lst, int level) {
            if (root == null) {
                return;
            }
            int val = root.val;
            if (level >= lst.size()) {
                List<Integer> currLst = new ArrayList<>();
                currLst.add(val);
                lst.add(currLst);
            } else {
                List<Integer> innerLst = lst.get(level);
                innerLst.add(val);
            }
            levelOrderHelper(root.left, lst, level + 1);
            levelOrderHelper(root.right, lst, level + 1);
        }
    }
}
