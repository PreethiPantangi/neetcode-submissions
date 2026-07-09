/**
 * Definition for singly-linked list.
 * class ListNode {
 *     constructor(val = 0, next = null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    /**
     * @param {ListNode} list1
     * @param {ListNode} list2
     * @return {ListNode}
     */
    mergeTwoLists(list1, list2) {
        let temp = new ListNode();
        let rootNode = temp;
        while(list1 !== null && list2 !== null) {
            if(list1.val < list2.val) {
                rootNode.next = list1;
                list1 = list1.next;
            } else {
                rootNode.next = list2;
                list2 = list2.next;
            }
            rootNode = rootNode.next;
        }
        if(list1) {
            rootNode.next = list1;
        }
        if(list2) {
            rootNode.next = list2;
        }
        return temp.next;
    }
}
