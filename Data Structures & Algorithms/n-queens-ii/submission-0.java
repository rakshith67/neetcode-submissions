class Solution {

    int count = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        fillPositions(board, 0);
        return count;
    }

    private void fillPositions(char[][] board, int row) {
        if (row == board.length) {
            count++;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q';
                fillPositions(board, row + 1);
                board[row][i] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int column) {
        for (int i = 0; i < row; i++) {
            if (board[i][column] == 'Q') {
                return false;
            }
        }

        int i = row - 1;
        int j = column + 1;
        while (i >= 0 && j < board.length) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        i = row - 1;
        j = column - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        return true;
    }
}