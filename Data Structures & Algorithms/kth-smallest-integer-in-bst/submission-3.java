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
    int idx = 0;

    public int kthSmallest(TreeNode root, int k) {
        return dfs(root, k);
    }

    private int dfs(TreeNode root, int k) {
        if (root == null) { 
            return -1;
        }

        int left = dfs(root.left, k);
        if (left != -1) {
            return left;
        }

        idx++;
        if (idx == k) {
            return root.val;
        }

        return dfs(root.right, k);
    }
}
