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

        Node tempHead  = head;
        while(tempHead != null) {
            map.put(tempHead, new Node(tempHead.val));
            tempHead = tempHead.next;
        }

        tempHead  = head;
        Node result = new Node(-1);
        Node dummy = result;
        while(tempHead != null) {
            Node newNode = map.get(tempHead);
            newNode.next = map.get(tempHead.next);
            newNode.random = map.get(tempHead.random);
            
            tempHead = tempHead.next;
            dummy.next = newNode;
            dummy = dummy.next;
        }
        return result.next;
    }
}
