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
        Node temp = head;

        while(temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        Node result = new Node(-1);
        Node dummyResult = result;
        while(temp != null) {
            Node newNode = map.get(temp);
            newNode.next = map.get(temp.next);
            newNode.random = map.get(temp.random);

            dummyResult.next = newNode;
            dummyResult = dummyResult.next;

            temp = temp.next;
        }
        return result.next;
    }
}
