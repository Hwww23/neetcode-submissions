class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] f : flights) {
            graph.get(f[0]).add(new int[] {f[1], f[2]});
        }

        int[][] dist = new int[n][k + 2];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[src][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {src, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if (node == dst) return cost;

            if (stops == k + 1 || cost > dist[node][stops]) continue;

            for (int[] nei : graph.get(node)) {
                int newCost = cost + nei[1];

                if (newCost < dist[nei[0]][stops + 1]) {
                    dist[nei[0]][stops + 1] = newCost;
                    pq.offer(new int[] {nei[0], newCost, stops + 1});
                }
            }
        }

        return -1;
    }
}
