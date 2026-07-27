class TimeMap {
    class Node {
        String s;
        int time;

        Node(String s, int time) {
            this.s = s;
            this.time = time;
        }
    }

    HashMap<String, List<Node>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hm.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (hm.get(key) == null) {
            return "";
        }        

        List<Node> list = hm.get(key);
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - 1) / 2;
            Node node = list.get(mid);

            if (timestamp < node.time) {
                r = mid - 1;
            } else if (timestamp > node.time) {
                l = mid + 1;
            } else {
                return node.s;
            }
        }

        return r < 0 ? "" : list.get(r).s;
    }
}
