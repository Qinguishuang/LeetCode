package lcof.No_01_20;

public class No12 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        int[] pathLength = {0};
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                if (hasPath(board, word, i, j, isVisited, pathLength)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPath(char[][] board, String word, int i, int j, boolean[][] isVisited, int[] pathLength) {
        boolean flag = false;
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length &&
                !isVisited[i][j] && board[i][j] == word.charAt(pathLength[0])) {
            pathLength[0]++;
            isVisited[i][j] = true;
            if (pathLength[0] == word.length())
                return true;
            flag = hasPath(board, word, i + 1, j, isVisited, pathLength) ||
                    hasPath(board, word, i - 1, j, isVisited, pathLength) ||
                    hasPath(board, word, i, j + 1, isVisited, pathLength) ||
                    hasPath(board, word, i, j - 1, isVisited, pathLength);
            if (!flag) {
                pathLength[0]--;
                isVisited[i][j] = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        No12 n = new No12();
        char[][] c = {{'a'}};
        System.out.println(n.exist(c, "a"));
    }


}
