class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        char first = word.charAt(0);
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (first == board[i][j]) {
                    if (hasWordDFS(board, visited, word, i, j, 0)) {
                        return true;
                    } else {
                        visited = new boolean[rows][columns];
                    }
                }
            }
        }
        return false;
    }

    private boolean hasWordDFS(char[][] board, boolean[][] visited, String word, int row, int column, int index) {
        if (index == word.length()) {
             return true;
        }

        if (row < 0 || column < 0 || row == board.length || column == board[0].length) {
            return false;
        }

        if (word.charAt(index) != board[row][column] || visited[row][column]) {
            // System.out.println(row + " " + column + " " + word.charAt(index) + " " + board[row][column]);
            return false;
        }
        
        visited[row][column] = true;
        System.out.println(row + " " + column);
        boolean result = hasWordDFS(board, visited, word, row + 1, column, index + 1)
                || hasWordDFS(board, visited, word, row - 1, column, index + 1)
                || hasWordDFS(board, visited, word, row, column + 1, index + 1)
                || hasWordDFS(board, visited, word, row, column - 1, index + 1);
        
        if (result == false) {
            visited[row][column] = false;
        }
        return result;
    }
}
