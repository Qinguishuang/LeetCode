package CS_Note.first.dp;

public class No121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int min = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > ans) {
                ans = prices[i] - min;
            }
            if (prices[i] < min) {
                min = prices[i];
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        No121 n = new No121();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(n.maxProfit(prices));
    }
}
