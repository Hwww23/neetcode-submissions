class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : hand) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : hm.keySet()) {
            pq.offer(i);
        }

        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && hm.get(pq.peek()) == 0) {
                pq.poll();
            }

            if (pq.isEmpty()) break;

            int end = pq.peek();

            for (int i = end; i > end - groupSize; i--) {
                if (hm.get(i) == null || hm.get(i) == 0) return false;

                hm.put(i, hm.get(i) - 1);
            }
        }

        return true;
    }
}
