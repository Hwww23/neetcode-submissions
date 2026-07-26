class BrowserHistory {
    private Stack<String> back;
    private Stack<String> front;

    public BrowserHistory(String homepage) {
        back = new Stack<>();
        front = new Stack<>();
        back.push(homepage);
    }
    
    public void visit(String url) {
        back.push(url);
        front.clear();
    }
    
    public String back(int steps) {
        while (steps > 0 && back.size() > 1) {
            front.push(back.pop());
            steps--;
        }

        return back.peek();
    }
    
    public String forward(int steps) {
        while (steps > 0 && !front.isEmpty()) {
            back.push(front.pop());
            steps--;
        }

        return back.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */