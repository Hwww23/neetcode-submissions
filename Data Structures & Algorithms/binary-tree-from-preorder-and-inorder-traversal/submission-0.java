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
    HashMap<Integer, Integer> hm;
    int idx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hm = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int l, int r) {
        if (l > r) {
            return null;
        }

        int pos = hm.get(preorder[idx]);
        TreeNode root = new TreeNode(preorder[idx++]);

        root.left = dfs(preorder, l, pos - 1);
        root.right = dfs(preorder, pos + 1, r);

        return root;
    }
}
