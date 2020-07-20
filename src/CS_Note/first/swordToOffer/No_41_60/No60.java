package CS_Note.first.swordToOffer.No_41_60;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class No60 {
    /**
     * 把 n 个骰子扔在地上，求点数和为 s 的概率。
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        long[][] dp = new long[n + 1][6 * n + 1]; // 一个骰子一行, 列从0-6*n;
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6 && k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        final double totalNum = Math.pow(6, n);
        List<Map.Entry<Integer, Double>> result = new ArrayList<>();
        for (int i = n; i <= 6 * n; i++) {
            result.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));
        }
        return result;
    }
}