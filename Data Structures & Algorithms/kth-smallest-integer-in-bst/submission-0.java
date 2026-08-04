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
    boolean found = false;
    int idx = 0;
    int val = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return val;
    }

    private void dfs(TreeNode root, int k) {
        if (found || root == null) return;

        dfs(root.left, k);
        idx++;

        if (idx == k) {
            val = root.val;
            found = true;
            return;
        }

        dfs(root.right, k);

        return;
    }
}
