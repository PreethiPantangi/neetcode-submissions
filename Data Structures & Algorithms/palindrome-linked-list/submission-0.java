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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;

        while(current != null) {
            stack.add(current.val);
            current = current.next;
        }

        current = head;
        while(current != null && current.val == stack.peek()) {
            stack.pop();
            current = current.next;
        }
        return stack.size() == 0;
    }
}