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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode list1 = mergeSort(lists, start, mid);
        ListNode list2 = mergeSort(lists, mid + 1, end);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode toReturn = result;
        while (list1 != null || list2 != null) {
            int first = list1 == null ? Integer.MAX_VALUE : list1.val;
            int second = list2 == null ? Integer.MAX_VALUE : list2.val;
            if (first < second) {
                result.next = list1;
                list1 = list1.next;
            } else {
                result.next = list2;
                list2 = list2.next;
            }
            result = result.next;
        }
        return toReturn.next;
    }
}
