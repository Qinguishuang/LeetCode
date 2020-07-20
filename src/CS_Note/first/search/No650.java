package CS_Note.first.search;

public class No650 {
    public int minSteps(int n) {
        if (n <= 0)
            return 0;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = (int) Math.sqrt(i); j >= 2; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }
}
