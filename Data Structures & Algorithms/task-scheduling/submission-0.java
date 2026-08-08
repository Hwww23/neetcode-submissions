class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        HashMap<Character, Integer> hm = new HashMap<>();
        Queue<int[]> cd = new LinkedList<>();

        for (char c : tasks) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        pq.addAll(hm.values());

        int time = 0;
        while (!pq.isEmpty() || !cd.isEmpty()) {
            if (!cd.isEmpty() && cd.peek()[1] == time) {
                pq.offer(cd.poll()[0]);
            }

            if (!pq.isEmpty()) {
                int rem = pq.poll();
                rem--;

                if (rem > 0) {
                    cd.offer(new int[] {rem, time + n + 1});
                }
            }

            time++;
        }

        return time;
    }
}
