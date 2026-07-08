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
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse(slow.next);
        // System.out.println(slow.val);
        ListNode temp = slow;
        slow = slow.next;
        temp.next = null;
        // System.out.println(slow.val);
        ListNode next = null;
        ListNode slowNext = null;
        while (slow != null) {
            next = head.next;
            slowNext = slow.next;
            head.next = slow;
            slow.next = next;
            head = next;
            slow = slowNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
