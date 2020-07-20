package CS_Note.second.dp;

public class No322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0)
            return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = i + 1;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != (i - coins[j] + 1)) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] != amount + 1)
            return dp[amount];
        else
            return -1;
    }

    public static void main(String[] args) {
        No322 n = new No322();
        int[] coins = {2};

        System.out.println(n.coinChange(coins, 3));
    }
}
