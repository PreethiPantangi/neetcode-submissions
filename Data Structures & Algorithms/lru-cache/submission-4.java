class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private Map<Integer, Node> cache = new HashMap<>();
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
            
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            insertNodeAtHead(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            node.value = value;
            insertNodeAtHead(node);
            return;
        } else {
            if(cache.size() == this.capacity) {
                removeTailNode();
            }
            Node newNode = new Node(key, value);
            insertNodeAtHead(newNode);
            cache.put(key, newNode);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertNodeAtHead(Node newNode) {
        newNode.next = this.head.next;
        newNode.prev = this.head;

        this.head.next.prev = newNode;
        this.head.next = newNode;
    }

    private void removeTailNode() {
        Node lru = tail.prev;
        removeNode(lru);
        cache.remove(lru.key);
    }

}

