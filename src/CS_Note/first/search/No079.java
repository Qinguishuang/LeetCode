package CS_Note.first.search;

public class No079 {
    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     */
    private int[][] isVisited;
    private String s;

    public boolean exist(char[][] board, String word) {
        if (board == null || board[0].length == 0 || word == null || word.length() == 0)
            return false;
        isVisited = new int[board.length][board[0].length];
        s = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(i, j, 0, board)) // 从(0, 0)坐标, 第0个字符开始
                    return true;
            }
        }
        return false;
    }

    public boolean exist(int r, int c, int i, char[][] board) {
        if (i == s.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length ||
                s.charAt(i) != board[r][c] || isVisited[r][c] == 1) {
            return false;
        }
        isVisited[r][c] = 1;

        if (exist(r - 1, c, i + 1, board))
            return true;
        if (exist(r + 1, c, i + 1, board))
            return true;
        if (exist(r, c - 1, i + 1, board))
            return true;
        if (exist(r, c + 1, i + 1, board))
            return true;

        isVisited[r][c] = 0;
        return false;
    }


    public static void main(String[] args) {
        No079 n = new No079();
        // char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        // String word = "AB";
        char[][] board = {{'a'}};
        String word = "a";
        System.out.println(n.exist(board, word));
    }
}
