package book.chapter4;

public class No15 {
    /**
     * -2 -3 3
     * -5 -10 1
     * 0 30 -5
     */
    public static int minHP(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];

        // 初始化终点的血量
        int row = arr.length;
        int col = arr[0].length;

        // 初始化终点的血量 6
        dp[row - 1][col - 1] = 1 - arr[row - 1][col - 1];
        if (dp[row - 1][col - 1] <= 0) {
            dp[row - 1][col - 1] = 1;
        }

        // 初始化最后一行, 从倒数第二列开始 1 1 6
        for (int i = col - 2; i >= 0; i--) {
            dp[row - 1][i] = Math.max(1, dp[row - 1][i + 1] - arr[row - 1][i]);
        }
        // 从倒数第二行开始
        for (int i = row - 2; i >= 0; i--) {
            // 初始化每行最后一个值
            dp[i][col - 1] = Math.max(1, dp[i + 1][col - 1] - arr[i][col - 1]);
            for (int j = col - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) - arr[i][j];
                if (dp[i][j] <= 0)
                    dp[i][j] = 1;
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] arr = {{-2, -3, 3}, {-5, -10, 1}, {0, 30, -5}};
        System.out.println(minHP(arr));
    }
}
