package CS_Note.first.search;

public class No037 {
    /**
     * 编写一个程序，通过已填充的空格来解决数独问题。
     */
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int[][] isVisit = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '*') {
                    isVisit[i][j] = 1;
                }
            }
        }
    }
}
