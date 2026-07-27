class Solution {
    private int[][] memo;
    private int max = 0;

    public int maximalSquare(char[][] matrix) {
        memo = new int[matrix.length][matrix[0].length];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = dfs(i, j, matrix);
                max = Math.max(max, len);
            }
        }

        return max * max;
    }

    private int dfs(int i, int j, char[][] matrix) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == '0') {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int bot = dfs(i + 1, j, matrix);
        int right = dfs(i, j + 1, matrix);
        int botright = dfs(i + 1, j + 1, matrix);

        return memo[i][j] = 1 + Math.min(bot, Math.min(right, botright));
    }
}