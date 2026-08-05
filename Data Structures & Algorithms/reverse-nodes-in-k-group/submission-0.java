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
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode result = new ListNode();
        ListNode prevHead = result;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (length < k) {
                break;
            }
            length -= k;
            ListNode prev = null;
            ListNode next = null;
            ListNode tail = temp;
            int i = k;
            while (i > 0) {
                next = temp.next;
                temp.next = prev;
                prev = temp;
                temp = next;
                i--;
            }
            prevHead.next = prev;
            tail.next = temp;
            prevHead = tail;
        }
        return result.next;
    }
}
