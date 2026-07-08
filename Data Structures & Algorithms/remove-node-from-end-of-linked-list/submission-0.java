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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        int toRemove = length - n;
        if (n < 0) {
            return head;
        } else if (n == 0) {
            return head.next;
        }
        temp = head;
        int count = 0;
        ListNode result = new ListNode(-1);
        ListNode prev = result;
        prev.next = temp;
        while (temp != null) {
            if (count == toRemove) {
                prev.next = temp.next;
                break;
            } else {
                prev = temp;
                temp = temp.next;
                count++;
            }
        }
        return result.next;
    }
}
