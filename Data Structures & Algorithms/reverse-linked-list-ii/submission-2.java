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
        if (head == null || left == right) {
            return head;
        }
        int count = 1;
        ListNode prev = null;
        ListNode rightNode = null;
        ListNode leftNode = null;
        ListNode leftPrevious = null;
        ListNode rightNext = null;
        ListNode temp = head;
        while (rightNode == null) {
            if (count == left) {
                leftPrevious = prev;
                leftNode = temp;
            } else if (count == right) {
                rightNode = temp;
                rightNext = temp.next;
            }
            count++;
            prev = temp;
            temp = temp.next;
        }
        ListNode reverse = reverse(leftNode, right - left);
        // System.out.println(leftNode.val + " " + rightNode.val + " " + reverse.val);
        if (leftPrevious == null) {
            head = reverse;
        } else {
            leftPrevious.next = reverse;
        }
        leftNode.next = rightNext;
        return head;
    }

    private ListNode reverse(ListNode head, int length) {
        int count = 0;
        ListNode prev = null;
        ListNode next = null;
        while (head != null && count <= length) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            count++;
        }
        return prev;
    }

}