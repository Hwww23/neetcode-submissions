class Solution {
    int[][] memo;
    // int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        memo = new int[matrix.length][matrix[0].length];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(i, j, matrix, -1));
            }
        }

        return max;
    }

    private int dfs(int i, int j, int[][] matrix, int prev) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prev) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int max = 1;
        for (int[] d : dir) {
            // int r = i + d[0];
            // int c = j + d[1];

            // if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length) continue;

            // if (matrix[r][c] > matrix[i][j]) {
            //     max = Math.max(max, 1 + dfs(r, c, matrix));
            // }

            max = Math.max(max, 1 + dfs(i + d[0], j + d[1], matrix, matrix[i][j]));
        }

        return memo[i][j] = max;
    }
}
