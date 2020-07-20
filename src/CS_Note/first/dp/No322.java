package CS_Note.first.dp;

public class No322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
