class LRUCache {
    class ListNode {
        int val;
        int key;
        ListNode next;
        ListNode prev;

        ListNode(int val, int key) {
            this.val = val;
            this.key = key;
            this.next = null;
            this.prev= null;
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

        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;

        ListNode prevTail = tail.prev;
        prevTail.next = node;
        node.prev = prevTail;
        node.next = tail;
        tail.prev = node;

        return node.val;
    }
    
    public void put(int key, int value) {
        if (hm.get(key) != null) {
            ListNode prevNode = hm.get(key);
            ListNode prev = prevNode.prev;
            ListNode next = prevNode.next;
            prev.next = next;
            next.prev = prev;
        } else {
            size++;
        }

        ListNode node = new ListNode(value, key);
        hm.put(key, node);

        ListNode prevTail = tail.prev;
        prevTail.next = node;
        node.prev = prevTail;
        node.next = tail;
        tail.prev = node;

        if (size > cap) {
            ListNode del = head.next;
            ListNode next = del.next;
            next.prev = head;
            head.next = next;
            hm.remove(del.key);
            
            size--;
        }
    }
}
