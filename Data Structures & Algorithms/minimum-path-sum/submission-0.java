class Solution {
    int[][] memo;
    
    public int minPathSum(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dfs(0, 0, grid);
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i >= grid.length || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        return memo[i][j] = grid[i][j] + Math.min(dfs(i + 1, j, grid), dfs(i, j + 1, grid));
    }
}