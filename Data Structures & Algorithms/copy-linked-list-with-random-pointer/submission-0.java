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
        
        if(head == null) return head;

        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;

        while(current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while(current != null) {
            Node copiedNode = map.get(current);
            copiedNode.next = map.get(current.next);
            copiedNode.random = map.get(current.random);

            current = current.next;
        }
        return map.get(head);
    }
}
