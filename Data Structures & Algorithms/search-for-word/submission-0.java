class Solution {
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(0, i, j, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int idx, int i, int j, char[][] board, String word) {
        if (idx == word.length()) {
            return true;
        }

        if ( i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '*'
            || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '*';
        for (int[] d : dir) {
            if (dfs(idx + 1, i + d[0], j + d[1], board, word)) {
                return true;
            }
        }

        board[i][j] = temp;
        return false;
    }
}
