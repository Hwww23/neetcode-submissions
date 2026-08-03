class TimeMap {
    class Node {
        String str;
        int time;

        Node(String str, int time) {
            this.str = str;
            this.time = time;
        }
    }

    private HashMap<String, ArrayList<Node>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hm.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Node> list = hm.get(key);
        
        if (list == null) {
            return "";
        }
        
        int l = 0;
        int r = list.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            Node node = list.get(mid);

            if (node.time < timestamp) {
                l = mid + 1;
            } else if (node.time > timestamp) {
                r = mid - 1;
            } else {
                return node.str;
            }
        }

        return r < 0 ? "" : list.get(r).str;
    }
}
