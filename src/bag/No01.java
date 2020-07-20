package bag;

public class No01 {
    /**
     * 背包问题
     * 0/1背包(每个物品要么拿（1个）要么不拿（0个）)
     * f[i][v] // 从前i件物品中选择放入容量为v的背包的最大价值
     * f[i][v] = max(f[i - 1][v], f[i - 1][v - weight[i]] + value[i])
     */
    public static void main(String[] args) {
        int[] weight = {2, 2, 6, 5, 4};
        int[] value = {6, 3, 5, 4, 6};
        int capital = 10;
        System.out.println(bag(weight, value, capital));
    }

    public static int bag(int[] weight, int[] value, int capital) {
        int[][] dp = new int[weight.length + 1][capital + 1];
        for (int i = 1; i < weight.length + 1; i++) { // 依次放入每一件
            for (int j = 1; j < capital + 1; j++) { // 容量从0到最大
                if (weight[i - 1] > j) { // 第i件物品放不进
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        int maxValue = dp[weight.length][capital];
        StringBuilder sb = new StringBuilder();
        int j = capital;
        for (int i = weight.length; i > 0; i--) {
            if (dp[i][j] > dp[i - 1][j]) {
                sb.append(i).append(" ");
                j = j - weight[i - 1];
            }
            if (j == 0)
                break;
        }
        System.out.println(maxValue);
        System.out.println(sb.reverse());
        return maxValue;
    }
}
