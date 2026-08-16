class Solution {
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        char[][] copy = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copy[i][j] = 'X'; 
            }
        }
        
        for (int j = 0; j < board[0].length; j++) {
            dfs(0, j, copy, board);
            dfs(board.length - 1, j, copy, board);
        }

        for (int i = 0; i < board.length; i++) {
            dfs(i, 0, copy, board);
            dfs(i, board[0].length - 1, copy, board);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (copy[i][j] == 'X') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] copy, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
            || board[i][j] == 'X' || copy[i][j] == '.') {
            return;
        }

        copy[i][j] = '.';

        for (int[] d : dir) {
            dfs(i + d[0], j + d[1], copy, board);
        }

    }
}
