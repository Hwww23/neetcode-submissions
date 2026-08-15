class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet[] row = new HashSet[9];
        HashSet[] col = new HashSet[9];
        HashSet[] grid = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            grid[i] = new HashSet<>();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    if (!row[i].add(board[i][j]) || !col[j].add(board[i][j])
                        || !grid[i / 3 * 3 + j / 3].add(board[i][j])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
