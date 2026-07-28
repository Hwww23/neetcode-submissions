/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Node> hs = new HashSet<>();

        while (p != null) {
            hs.add(p);
            p = p.parent;
        }

        while (q != null) {
            if (hs.contains(q)) return q;
            q = q.parent;
        }

        return null;
    }
}