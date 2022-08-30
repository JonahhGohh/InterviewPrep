package LeetCode;

public class ValidateBinarySearchTree {
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
        public boolean isValidBST(TreeNode root) {
            long leftBound = (long)(Integer.MIN_VALUE) - 1;
            long rightBound = (long)(Integer.MAX_VALUE) + 1;
            return helper(root.left, leftBound, root.val) && helper(root.right, root.val, rightBound);
        }

        boolean helper(TreeNode root, long leftBound, long rightBound) {
            // System.out.println(leftBound + ", " + rightBound);
            if (root == null) {
                return true;
            }

            long val = root.val;
            // System.out.println(val);
            if (val <= leftBound || val >= rightBound) {
                return false;
            }

            return helper(root.left, leftBound, val) && helper(root.right, val, rightBound);
        }
    }
}
