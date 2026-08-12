class Solution {
    int[][] memo;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        return dfs(0, 0, obstacleGrid);
    }


    private int dfs(int i, int j, int[][] grid) {
        if (i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
            return 0;
        }
        
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        return memo[i][j] = dfs(i + 1, j, grid) + dfs(i, j + 1, grid);
    }
}