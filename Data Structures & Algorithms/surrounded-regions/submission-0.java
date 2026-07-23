class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        int row = 0;
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == 'O') {
                dfs(board, visited, row, j);
            }
        }

        row = board.length - 1;
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == 'O') {
                dfs(board, visited, row, j);
            }
        }

        int column = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == 'O') {
                dfs(board, visited, i, column);
            }
        }

        column = board[0].length - 1;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] == 'O') {
                dfs(board, visited, i, column);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int row, int column) {
        if (row < 0 || column < 0 || row == board.length || column == board[0].length
            || board[row][column] == 'X' || visited[row][column]) {
            return;
        }

        visited[row][column] = true;
        dfs(board, visited, row - 1, column);
        dfs(board, visited, row + 1, column);
        dfs(board, visited, row, column + 1);
        dfs(board, visited, row, column - 1);
    }
}
