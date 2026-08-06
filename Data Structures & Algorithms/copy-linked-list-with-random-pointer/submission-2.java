/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> hm;

    public Node copyRandomList(Node head) {
        hm = new HashMap<>();
        return dfs(head);
    }

    private Node dfs(Node head) {
        if (head == null) return null;

        if (hm.get(head) != null) return hm.get(head);

        Node copy = new Node(head.val);
        hm.put(head, copy);
        copy.next = dfs(head.next);
        copy.random = dfs(head.random);

        return copy;
    }
}
