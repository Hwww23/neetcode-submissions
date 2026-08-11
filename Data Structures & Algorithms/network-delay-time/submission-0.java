class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            graph.get(time[0]).add(new int[] {time[1], time[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {k, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int u = node[0];
            int curr = node[1];

            if (curr > dist[u]) continue;

            for (int[] nei : graph.get(u)) {
                int v = nei[0];
                int weight = nei[1];

                int newDist = curr + weight;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new int[] {v, newDist});
                }
            }
        }

        int res = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            res = Math.max(res, dist[i]);
        }

        return res;
    }
}
