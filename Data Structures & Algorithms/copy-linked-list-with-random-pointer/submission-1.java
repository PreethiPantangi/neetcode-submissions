/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node tempHead = head;
        while(tempHead  != null) {
            map.put(tempHead, new Node(tempHead.val));
            tempHead = tempHead.next;
        }

        tempHead = head;
        Node result = new Node(-1);
        Node dummy = result;
        while(tempHead != null) {
            Node node = map.get(tempHead);
            node.next = map.get(tempHead.next);
            node.random = map.get(tempHead.random);

            dummy.next = node;
            dummy = dummy.next;

            tempHead = tempHead.next;
        }
        return result.next;
    }
}
