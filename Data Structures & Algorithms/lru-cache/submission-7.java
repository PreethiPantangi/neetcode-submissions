class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
            
    public int get(int key) {
        // If cache contains the key 
            // Remove the node from the DLL
            // Add the Node at the head of the linked list
            // return value from Node
        // Else
            // return -1;

        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            addNodeAtHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // If cache contains the key 
            // Remove the node from the DLL
            // Update the value of the Node
            // Add the Node at the head of the linked list
            // return value from Node
        // Else
            // if capacity is full, if yes we will remove the node before tail
            // create a new node at the head of the linked list

        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            node.value = value;
            addNodeAtHead(node);
            return;
        }
        if(cache.size() == this.capacity) {
            removeNodeAtTail();
        }

        Node newNode = new Node(key, value);
        addNodeAtHead(newNode);
        cache.put(key, newNode);
    }

    private void removeNode(Node node) {
        // -1 -> 1 -> -1
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    private void addNodeAtHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNodeAtTail() {
        Node node = tail.prev;
        removeNode(node);
        cache.remove(node.key);
    }

}

