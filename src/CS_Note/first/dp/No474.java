package CS_Note.first.dp;

public class No474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0)
            return 0;
        // m 0的数量, n 1的数量
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) { // 每个字符串用一次
            int ones = 0, zeros = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) { // 0的个数可以满足
                for (int j = n; j >= ones; j--) { // 1的个数可以满足
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
