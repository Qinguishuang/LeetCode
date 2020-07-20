package book.chapter4;

public class No04 {
    /**
     * 递归
     * 达到指定位置的方法数
     *
     * @param N 数量
     * @param M 起点
     * @param K 步数
     * @param P 终点
     * @return 多少种方法
     */
    public static int walk(int N, int M, int K, int P) {
        if (K == 0) { // 次数走完了, 如果到达目的地, 符合条件
            return M == P ? 1 : 0;
        }
        if (M == 1) { // 当前在1, 只能向右走
            return walk(N, M + 1, K - 1, P);
        }
        if (M == N) { // 当前在最后, 只能向左走
            return walk(N, M - 1, K - 1, P);
        }
        return walk(N, M - 1, K - 1, P) + walk(N, M + 1, K - 1, P);
    }

    /**
     * 动态规划
     *
     * @param N 数量
     * @param M 起点
     * @param K 步数
     * @param P 终点
     * @return 多少种方法
     */
    public static int walk2(int N, int M, int K, int P) {
        // 行 剩余步数
        // 列 当前位置
        int[][] dp = new int[K + 1][N + 1];
        dp[0][P] = 1;
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) { // 第一列, 当前位置1
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == N) { // 最后一列
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        return dp[K][M];
    }


    public static void main(String[] args) {
        int counts = walk(5, 2, 3, 3);
        System.out.println(counts);
    }
}
