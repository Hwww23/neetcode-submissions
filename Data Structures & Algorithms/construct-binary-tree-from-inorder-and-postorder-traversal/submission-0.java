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
    private HashMap<Integer, Integer> hm = new HashMap<>();
    private int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return dfs(postorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] postorder, int l, int r) {
        if (l > r) {
            return null;
        }

        int val = postorder[idx--];
        int pos = hm.get(val);
        TreeNode root = new TreeNode(val);

        root.right = dfs(postorder, pos + 1, r);
        root.left = dfs(postorder, l, pos - 1);

        return root;
    }
}