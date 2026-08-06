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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;

        int k = left - 1;
        while (k-- > 0) {
            start = start.next;
        }

        ListNode curr = start.next;

        k = right - left;
        while (k-- > 0) {
            ListNode front = curr.next;
            curr.next = front.next;
            front.next = start.next;
            start.next = front;
        }

        return dummy.next;
    }
}