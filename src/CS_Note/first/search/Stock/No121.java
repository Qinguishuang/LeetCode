package CS_Note.first.search.Stock;

public class No121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > max) {
                max = prices[i] - min;
            } else if (prices[i] < min) {
                min = prices[i];
            }
        }
        return max;
    }

    /**
     * dp[3][2][1]
     * 天, 交易次数, 今天是否持有
     * 今天是第三天，我现在手上持有着股票，至今最多进行 2 次交易。
     */
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 解释：今天我没有持有股票，有两种可能：
            // 要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
            // 要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。

            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            // 解释：今天我持有着股票，有两种可能：
            // 要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
            // 要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。
        }
        return dp[dp.length - 1][0];
    }

    public static void main(String[] args) {
        No121 n = new No121();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4}; // 7
        System.out.println(n.maxProfit2(prices));
    }
}
