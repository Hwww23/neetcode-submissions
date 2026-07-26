class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        List<List<int[]>> adj = new ArrayList<>();
        int[][] dist = new int[n][k + 2];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }

        pq.offer(new int[] {0, src, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();

            int cost = node[0];
            int curr = node[1];
            int flightsUsed = node[2];

            if (curr == dst) return cost;

            if (cost > dist[curr][flightsUsed]) continue;
            if (flightsUsed == k + 1) continue; 

            for (int[] nei : adj.get(curr)) {
                if (cost + nei[1] < dist[nei[0]][flightsUsed + 1]) {
                    pq.offer(new int[] {cost + nei[1], nei[0], flightsUsed + 1});
                }
            }
        }

        return -1;
    }
}
