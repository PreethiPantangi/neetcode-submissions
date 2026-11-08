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
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        int carry = 0;

        while(list1 != null || list2 != null || carry != 0) {
            int sum = carry;

            if(list1 != null) {
                sum += list1.val;
                list1 = list1.next;
            }

            if(list2 != null) {
                sum += list2.val;
                list2 = list2.next;
            }

            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;
            carry = sum / 10;
        }
        return result.next;
    }
}
