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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = slow;
        ListNode curr = slow.next;

        while (curr.next != null) {
            ListNode temp = curr.next;
            curr.next = curr.next.next;
            temp.next = first.next;
            first.next = temp;
        }

        ListNode second = slow.next;
        slow.next = null;

        first = head;
        while (second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;

            first.next = second;
            second.next = next1;
            
            first = next1;
            second = next2;
        }
    }
}
