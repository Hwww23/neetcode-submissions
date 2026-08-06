class LRUCache {
    class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode prev;

        ListNode(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }

    ListNode head;
    ListNode tail;
    int cap;
    int size;
    HashMap<Integer, ListNode> hm;

    public LRUCache(int capacity) {
        head = new ListNode(0, -1);
        tail = new ListNode(0, -1);
        head.next = tail;
        tail.prev = head;

        cap = capacity;
        size = 0;
        hm = new HashMap<>();
    }
    
    public int get(int key) {
        ListNode node = hm.get(key);
        
        if (node == null) return -1;

        remove(node);
        insertToBack(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        ListNode node = hm.get(key);

        if (hm.get(key) != null) {
            node.val = value;
            remove(node);
            insertToBack(node);
            return;
        }

        node = new ListNode(value, key);
        hm.put(key, node);
        insertToBack(node);
        size++;

        if (size > cap) {
            ListNode lru = head.next;
            remove(lru);
            hm.remove(lru.key);        
            size--;
        }
    }

    private void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToBack(ListNode node) {
        ListNode prev = tail.prev;

        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;
    }
}
