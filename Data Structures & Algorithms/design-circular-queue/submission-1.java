class MyCircularQueue {
    int[] arr;
    int front;
    int back;
    int size;

    public MyCircularQueue(int k) {
        arr = new int[k];
        front = 0;
        back = -1;
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;

        back = (back + 1) % arr.length;
        arr[back] = value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;

        front = (front + 1) % arr.length;
        size--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : arr[front];
    }
    
    public int Rear() {
        return isEmpty() ? -1 : arr[back];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == arr.length;
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