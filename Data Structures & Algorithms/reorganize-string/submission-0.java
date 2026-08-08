class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        for (int i : hm.values()) {
            max = Math.max(max, i);
        }

        if (max > (s.length() + 1) / 2) return "";

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> hm.get(b) - hm.get(a));
        pq.addAll(hm.keySet());
        StringBuilder res = new StringBuilder();

        while (pq.size() > 1) {
            char a = pq.poll();
            char b = pq.poll();

            int left = hm.get(a) - 1;
            if (left > 0) {
                hm.put(a, left);
                pq.offer(a);
            }
            
            left = hm.get(b) - 1;
            if (left > 0) {
                hm.put(b, left);
                pq.offer(b);
            }
            
            res.append(a);
            res.append(b);
        }

        if (pq.size() > 0) {
            res.append(pq.poll());
        }

        return res.toString();
    }
}