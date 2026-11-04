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
        List<List<Integer>> result = getNodeValues(head, k);
        ListNode root = new ListNode(-1);
        ListNode dummyRoot = root;
        for(int i = 0; i < result.size(); i++) {
            List<Integer> values = result.get(i);
            for(int j = 0; j < values.size(); j++) {
                dummyRoot.next = new ListNode(values.get(j));
                dummyRoot = dummyRoot.next;
            }
        }
        head = root.next;
        return head;
    }

    private List<List<Integer>> getNodeValues(ListNode head, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        ListNode tempHead = head;
        int count = 0;
        while(tempHead != null) {
            level.add(tempHead.val);
            tempHead = tempHead.next;
            count += 1;

            if (count == k) {
                Collections.reverse(level);
                result.add(level);
                level = new ArrayList<>();
                count = 0;
            }
            
        }
        result.add(level);
        return result;
    }
}
