package cz;

public class No999 {
    public int numRookCaptures(char[][] board) {
        if (board == null || board.length == 0)
            return 0;
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    // 往上计算
                    for (int k = i - 1; k >= 0; k--) {
                        if (board[k][j] == 'p') {
                            ans++;
                            break;
                        } else if (board[k][j] == 'B') {
                            break;
                        }
                    }
                    // 往右计算
                    for (int k = j + 1; k < board[i].length; k++) {
                        if (board[i][k] == 'p') {
                            ans++;
                            break;
                        } else if (board[i][k] == 'B') {
                            break;
                        }
                    }
                    // 往下计算
                    for (int k = i + 1; k < board.length; k++) {
                        if (board[k][j] == 'p') {
                            ans++;
                            break;
                        } else if (board[k][j] == 'B') {
                            break;
                        }
                    }
                    // 往左计算
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[i][k] == 'p') {
                            ans++;
                            break;
                        } else if (board[i][k] == 'B') {
                            break;
                        }
                    }
                    return ans;
                }
            }
        }
        return ans;
    }
}
