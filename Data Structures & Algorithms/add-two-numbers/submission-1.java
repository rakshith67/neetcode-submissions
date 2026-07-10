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
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = addNumbers(l1, l2);
        if (carry != 0) {
            ListNode temp = result;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(carry);
        }
        return result;
    }

    public ListNode addNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        int sum;
        boolean isL1Null = false;
        boolean isL2Null = false;
        if (l1 == null) {
            sum = l2.val + carry;
            isL1Null = true;
        } else if (l2 == null) {
            sum = l1.val + carry;
            isL2Null = true;
        } else {
            sum = l1.val + l2.val + carry;
        }
        carry = sum / 10;
        ListNode sumNode = new ListNode(sum % 10);
        sumNode.next = addNumbers(isL1Null ? null : l1.next, isL2Null ? null : l2.next);
        return sumNode;
    }

}
