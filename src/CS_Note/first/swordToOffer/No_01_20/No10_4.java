package CS_Note.first.swordToOffer.No_01_20;

public class No10_4 {
    /**
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。
     * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * f(n-1) = f(n-2) + f(n-3) + f(n-4) + ... + f(1)  (1)
     * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(1)  (2)
     * (1) - (2)得到
     * f(n) - f(n-1) = f(n-1)
     * f(n) = 2f(n-1) 等比数列
     * f(n) = 2 ^ (n-1)
     */
    public int JumpFloorII(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[n];
    }
}
