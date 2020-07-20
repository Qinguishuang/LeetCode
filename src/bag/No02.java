package bag;

public class No02 {
    /**
     * 完全背包(物品数量不限)
     * dp[i][j] = max(dp[i - 1][j - k * weight[i - 1]] + k * value[i - 1]); 0 < k * weight[i] < capital
     */
    public static void main(String[] args) {
        int[] weight = {2, 2, 6, 5, 4};
        int[] value = {6, 3, 5, 4, 6};
        int capital = 10;
        System.out.println(bag(weight, value, capital));
    }

    public static int bag(int[] weight, int[] value, int capital) {
        int[][] dp = new int[weight.length + 1][capital + 1];
        for (int i = 1; i <= weight.length; i++) { // 遍历每一件物品
            for (int j = 0; j <= capital; j++) { // 遍历容量
                for (int k = 0; j - k * weight[i - 1] >= 0; k++) { // 每一件商品放入多次
                    dp[i][j] = Math.max(dp[i - 1][j - k * weight[i - 1]] + value[i - 1] * k, dp[i][j]);
                }
            }
        }
        System.out.println(dp[weight.length][capital]);
        return -1;
    }
}
