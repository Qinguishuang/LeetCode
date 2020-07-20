package CS_Note.first.search;

public class No309 {
    /**
     * sell[i]表示截至第i天，最后一个操作是卖时的最大收益；
     * buy[i]表示截至第i天，最后一个操作是买时的最大收益；
     * cool[i]表示截至第i天，最后一个操作是冷冻期时的最大收益；
     * <p>
     * sell[i] = max(buy[i-1]+prices[i], sell[i-1]) (第一项表示第i天卖出，第二项表示第i天冷冻)
     * buy[i] = max(cool[i-1]-prices[i], buy[i-1]) （第一项表示第i天买进，第二项表示第i天冷冻）
     * cool[i] = max(sell[i-1], buy[i-1], cool[i-1])
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int[] sell = new int[prices.length + 1];
        int[] buy = new int[prices.length + 1];
        int[] cool = new int[prices.length + 1];
        for (int i = 0; i < prices.length; i++) {

        }

        return 0;
    }
}
