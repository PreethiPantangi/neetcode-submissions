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
    public boolean hasCycle(ListNode head) {
        ListNode pointerOne = head;
        ListNode pointerTwo = head;
        while(pointerTwo != null && pointerTwo.next != null) {
            pointerOne = pointerOne.next;
            pointerTwo = pointerTwo.next.next;
            if(pointerOne == pointerTwo) return true;
        }
        return false;
    }
}
