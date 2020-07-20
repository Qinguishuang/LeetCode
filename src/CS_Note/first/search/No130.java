package CS_Note.first.search;

public class No130 {

    public static void main(String[] args) {
        No130 n = new No130();
        // char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] board = {{'O','O'},{'O','O'}};
        n.solve(board);
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && (board[i][j] == 'O')) {
                    solve(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void solve(char[][] board, int r, int c) {
        if (board[r][c] == 'O') {
            board[r][c] = 'A';
        } else {
            return;
        }
        if (r - 1 >= 0)
            solve(board, r - 1, c);
        if (r + 1 < board.length)
            solve(board, r + 1, c);
        if (c - 1 >= 0)
            solve(board, r, c - 1);
        if (c + 1 < board[0].length)
            solve(board, r, c + 1);
    }

}
