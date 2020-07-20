package cz;

public class No289 {
    private int[] neighbors = {0, 1, -1};

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[] neighbors = {0, 1, -1};

        int[][] copy = new int[row][col];
        for (int i = 0; i < row; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, col);
        }
        for (int i = 0; i < row; i++) { // 遍历所有的格子
            for (int j = 0; j < col; j++) {
                int liveNeighbors = 0;
                for (int k = 0; k < 3; k++) { // 遍历八个邻居
                    for (int l = 0; l < 3; l++) {
                        if (!(neighbors[k] == 0 && neighbors[l] == 0)) { // 如果不是当前位置
                            int r = i + neighbors[k]; // 周围的新坐标
                            int c = j + neighbors[l];
                            if ((r < row && r >= 0) && (c < col && c >= 0) && copy[r][c] == 1) {
                                liveNeighbors++; // 周围的那个还活着
                            }
                        }
                    }
                }
                // 判断下个状态
                if (copy[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = 0;
                }
                if (copy[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public void gameOfLife_(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int live = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (!(neighbors[k] == 0 && neighbors[l] == 0)) {
                            int r = i + neighbors[k];
                            int c = j + neighbors[l];
                            if (r < row && r >= 0 && c < col && c >= 0) {
                                live += board[r][c] & 1; // 根据最后一位判断10
                            }
                        }
                    }
                }
                if ((board[i][j] & 1) > 0) { // 当前是活的
                    if (live == 2 || live == 3) {
                        board[i][j] = 0b11; // 下一个状态还是活的
                    }
                } else {
                    if (live == 3) {
                        board[i][j] = 0b10;
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
