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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode dummyResult = result;

        while(list1 != null && list2 != null) {
            if(list1.val == list2.val) {
                dummyResult.next = new ListNode(list1.val);
                dummyResult = dummyResult.next;
                list1 = list1.next;

                dummyResult.next = new ListNode(list2.val);
                dummyResult = dummyResult.next;
                list2 = list2.next;
            } else if (list1.val < list2.val) {
                dummyResult.next = new ListNode(list1.val);
                dummyResult = dummyResult.next;
                list1 = list1.next;
            } else {
                dummyResult.next = new ListNode(list2.val);
                dummyResult = dummyResult.next;
                list2 = list2.next;
            }
        }

        while(list1 != null) {
            dummyResult.next = new ListNode(list1.val);
            dummyResult = dummyResult.next;
            list1 = list1.next;
        }

        while(list2 != null) {
            dummyResult.next = new ListNode(list2.val);
            dummyResult = dummyResult.next;
            list2 = list2.next;
        }
        return result.next;
    }
}