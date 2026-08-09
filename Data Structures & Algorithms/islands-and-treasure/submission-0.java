class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0];
            int j = curr[1];

            for (int[] d : dir) {
                int r = i + d[0];
                int c = j + d[1];

                if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length 
                    || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }

                grid[r][c] = grid[i][j] + 1;
                q.offer(new int[] {r, c});
            }
        }
    }
}
