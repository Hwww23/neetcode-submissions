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
    HashMap<Node, Node> hm = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        if (hm.containsKey(head)) return hm.get(head);

        Node copy = new Node(head.val);
        hm.put(head, copy);
        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);

        return copy;
    }
}
