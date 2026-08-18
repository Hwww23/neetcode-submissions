class FreqStack {
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, Stack<Integer>> groups = new HashMap<>();
    int maxFreq = 0;

    public FreqStack() {
        
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);

        maxFreq = Math.max(maxFreq, f);

        groups.computeIfAbsent(f, k -> new Stack<>()).push(val);
    }
    
    public int pop() {
        Stack<Integer> s = groups.get(maxFreq);

        int val = s.pop();
        freq.put(val, freq.get(val) - 1);

        if (s.isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */