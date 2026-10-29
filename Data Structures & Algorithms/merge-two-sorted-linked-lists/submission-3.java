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
        ListNode currResult = result;

        while(list1 != null && list2 != null) {
            if(list1.val == list2.val) {
                currResult.next = new ListNode(list1.val);
                currResult = currResult.next;

                currResult.next = new ListNode(list2.val);
                currResult = currResult.next;

                list1 = list1.next;
                list2 = list2.next;
            } else if (list1.val < list2.val) {
                currResult.next = new ListNode(list1.val);
                list1 = list1.next;
                currResult = currResult.next;
            } else {
                currResult.next = new ListNode(list2.val);
                list2 = list2.next;
                currResult = currResult.next;
            }
        }

        while(list1 != null) {
            currResult.next = new ListNode(list1.val);
            list1 = list1.next;
            currResult = currResult.next;
        }

        while(list2 != null) {
            currResult.next = new ListNode(list2.val);
            list2 = list2.next;
            currResult = currResult.next;
        }

        return result.next;
    }
}