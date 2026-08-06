class MyCircularQueue {
    class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    
    ListNode head;
    ListNode tail;
    int cap;
    int fullCap;

    public MyCircularQueue(int k) {
        head= new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
        this.cap = k;
        this.fullCap = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        
        ListNode prev = tail.prev;
        ListNode newTail = new ListNode(value);
        newTail.prev = prev;
        prev.next = newTail;
        newTail.next = tail;
        tail.prev = newTail;
        cap--;
        
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;

        ListNode next = head.next.next;
        head.next = next;
        next.prev = head;
        cap++;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;

        return head.next.val;
    }
    
    public int Rear() {
        if (isEmpty()) return -1;

        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return cap == fullCap;
    }
    
    public boolean isFull() {
        return cap == 0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */