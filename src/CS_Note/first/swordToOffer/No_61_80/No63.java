package CS_Note.first.swordToOffer.No_61_80;

public class No63 {
    /**
     * 可以有一次买入和一次卖出，买入必须在前。求最大收益。
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        return max;
    }

}
