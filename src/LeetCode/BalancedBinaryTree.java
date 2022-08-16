package LeetCode;

public class BalancedBinaryTree {
    // 110. Balanced Binary Tree
    // https://leetcode.com/problems/balanced-binary-tree/
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return height(root) != -1;
        }

        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            if (leftHeight == -1 || rightHeight == -1) {
                return -1;
            }

            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
}
