public class Question079 {


    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word.toCharArray(), 0, i, j, used)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int start, int i, int j, boolean[][] used) {
        if (start >= word.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        boolean result = false;
        if (!used[i][j] && board[i][j] == word[start]) {
            used[i][j] = true;
            result = dfs(board, word, start + 1, i + 1, j, used) || dfs(board, word, start + 1, i - 1, j, used)
                    || dfs(board, word, start + 1, i, j + 1, used) || dfs(board, word, start + 1, i, j - 1, used);
            used[i][j] = false;
        }
        return result;
    }
}
