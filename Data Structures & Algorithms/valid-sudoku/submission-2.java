class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> squares = new HashMap<>();

        for(int i = 0; i < 9; i++){
            rows.put(i, new HashSet<>());
            columns.put(i, new HashSet<>());
            squares.put(i, new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (rows.get(i).contains(board[i][j])) {
                    return false;
                }
                if (columns.get(j).contains(board[i][j])) {
                    return false;
                }
                Integer squareIndex = 3 * (i / 3) + (j / 3);
                if (squares.get(squareIndex).contains(board[i][j])) {
                    return false;
                }
                rows.get(i).add(board[i][j]);
                columns.get(j).add(board[i][j]);
                squares.get(squareIndex).add(board[i][j]);
            }
        }
        return true;
    }
}
