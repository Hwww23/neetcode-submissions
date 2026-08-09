class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        int[][] effort = new int[heights.length][heights[0].length];

        for (int[] e : effort) {
            Arrays.fill(e, Integer.MAX_VALUE);
        }

        effort[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[1];
            int j = curr[2];

            if (i == heights.length - 1 && j == heights[0].length - 1) return curr[0];

            for (int[] d : dir) {
                int r = i + d[0];
                int c = j + d[1];

                if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length
                    || curr[0] > effort[i][j]) {
                    continue;
                }

                int newEffort = Math.max(curr[0], Math.abs(heights[r][c] - heights[i][j]));

                if (newEffort < effort[r][c]) {
                    effort[r][c] = newEffort;
                    pq.offer(new int[] {newEffort, r, c});
                }
            }
        }

        return -1;
    }

}