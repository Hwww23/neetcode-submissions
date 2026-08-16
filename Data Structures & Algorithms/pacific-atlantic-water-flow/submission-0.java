class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int j = 0; j < heights[0].length; j++) {
            int i = heights.length - 1;
            dfs(i, j, atlantic, heights);
        }

        for (int i = 0; i < heights.length; i++) {
            int j = heights[0].length - 1;
            dfs(i, j, atlantic, heights);
        }

        for (int i = 0; i < heights.length; i++) {
            int j = 0;
            dfs(i, j, pacific, heights);
        }

        for (int j = 0; j < heights[0].length; j++) {
            int i = 0;
            dfs(i, j, pacific, heights);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, boolean[][] grid, int[][] heights) {
        if (grid[i][j]) return;

        grid[i][j] = true;

        for (int[] d : dir) {
            int r = i + d[0];
            int c = j + d[1];

            if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length) continue;

            if (heights[r][c] >= heights[i][j]) {
                dfs(r, c, grid, heights);
            }
        }
    }
}
