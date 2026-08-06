/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private ListNode add(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;

        int left = l1 == null ? 0 : l1.val;
        int right = l2 == null ? 0 : l2.val;
        int val = left + right + carry;

        int curr = val % 10;
        int nextCarry = val / 10;

        ListNode node = new ListNode(curr);
        node.next = add(l1 == null ? l1 : l1.next,
                        l2 == null ? l2 : l2.next,
                        nextCarry);

        return node;
    }
}
