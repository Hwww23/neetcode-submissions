class Solution {
    int[][] memo;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};;

    public int longestIncreasingPath(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        memo = new int[ROWS][COLS];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        int max = 1;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                max = Math.max(max, dfs(i, j, matrix, -1));
            }
        }

        return max;
    }

    private int dfs(int i, int j, int[][] matrix, int prev) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        if (i < 0 || i >= ROWS || j < 0 || j >= COLS || matrix[i][j] <= prev) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = 1;
        for (int[] d : dir) {
            res = Math.max(res, 1 + dfs(i + d[0], j + d[1], matrix, matrix[i][j]));
        }

        return memo[i][j] = res;
    }
}
