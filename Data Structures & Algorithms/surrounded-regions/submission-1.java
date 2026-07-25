class Solution {
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        char[][] arr = new char[board.length][board[0].length];
        for (char[] c : arr) {
            Arrays.fill(c, 'X');
        }

        int[][] visited = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1
                    && board[i][j] == 'O') {
                    dfs(i, j, board, arr, visited);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (arr[i][j] == 'X') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board, char[][] res, int[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == 1 
            || board[i][j] == 'X') {
            return;
        }

        visited[i][j] = 1;
        res[i][j] = 'O';

        for (int[] d : dir) {
            dfs(i + d[0], j + d[1], board, res, visited);
        }        
    }
}
