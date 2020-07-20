package CS_Note.first.greedy;

public class No121 {

    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int ans = 0;
        int min_price = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            } else {
                ans = Math.max(prices[i] - min_price, ans);
            }
        }
        return ans;
    }
}
