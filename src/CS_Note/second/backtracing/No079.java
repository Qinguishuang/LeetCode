package CS_Note.second.backtracing;

public class No079 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board[0].length == 0)
            return false;
        if (word == null || word.length() == 0)
            return true;
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && backTracing(board, i, j, word, 0, isVisited))
                    return true;
            }
        }

        return false;
    }

    private boolean backTracing(char[][] board, int i, int j, String word, int k, boolean[][] isVisited) {
        if (k == word.length())
            return true;
        if (i < 0 || j < 0 || i > board.length || j > board[0].length
                || board[i][i] != word.charAt(k) || !isVisited[i][j])
            return false;
        isVisited[i][i] = true;
        return backTracing(board, i + 1, j, word, k + 1, isVisited) ||
                backTracing(board, i - 1, j, word, k + 1, isVisited) ||
                backTracing(board, i, j + 1, word, k + 1, isVisited) ||
                backTracing(board, i, j - 1, word, k + 1, isVisited);
    }


}
