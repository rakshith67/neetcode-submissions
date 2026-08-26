class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();

        Trie trie = new Trie();
        for (String word: words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.root.children[board[i][j] - 'a'] != null) {
                    hasWord(board, i, j, trie.root, result);
                }
            }
        }
        return new ArrayList<>(result);
    }

     private void hasWord(char[][] board, int row, int column, TrieNode root, Set<String> result) {
        if (row < 0 || column < 0 || row == board.length || column == board[0].length
                || board[row][column] == '#') {
            return;
        }

        char ch = board[row][column];
        root = root.children[ch - 'a'];
        if (root == null) {
            return;
        }
        if (root.endOfWord) {
            result.add(root.word);
        }
        board[row][column] = '#';
        hasWord(board, row + 1, column, root, result);
        hasWord(board, row - 1, column, root, result);
        hasWord(board, row, column + 1, root, result);
        hasWord(board, row, column - 1, root, result);
        board[row][column] = ch;
    }

    class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.endOfWord = true;
            current.word = word;
        }
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
        String word = "";
    }
}
