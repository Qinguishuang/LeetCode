package CS_Note.first.dp;

public class No518 {
    /**
     * 对于一种新的面值的硬币 coins[i - 1]（注意这里有一个位移偏差），
     * 我们可以依次考虑选取 0 枚、1 枚、2 枚，以此类推，
     * 直到选取这种面值的硬币的总金额超过“需要的总金额 j”，dp[i][j] 是它们的值的和。
     */
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;

        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) { // 遍历每一枚硬币
            for (int j = 0; j <= amount; j++) { // 从头开始加上新的硬币
                for (int k = 0; j - k * coins[i - 1] >= 0; k++) { // 新硬币逐渐增加
                    dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public int change2(int amount, int[] coins) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    public int change3(int amount, int[] coins) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[j] += dp[j - coins[i - 1]];
                }
            }
        }
        return dp[amount];
    }
}
