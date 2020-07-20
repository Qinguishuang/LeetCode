package lcof.No_41_60;

import java.util.ArrayList;
import java.util.List;

public class No60 {
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][n * 6 + 1];
        List<Double> ans = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1; // 初始化第一个骰子🎲
        }
        for (int i = 2; i <= n; i++) { // 遍历每一个骰子
            for (int j = i; j <= 6 * n; j++) { // 第二个骰子范围(2 - 12)(i - 6 * i)
                for (int k = 1; k <= 6 && k <= j; k++) { // 计算出现次数
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        final double totalNum = Math.pow(6, n);
        double[] res = new double[5 * n + 1];
        int index = 0;
        for (int i = n; i <= 6 * n; i++) {
            res[index++] = dp[n][i] / totalNum;
        }
        return res;
    }
}
