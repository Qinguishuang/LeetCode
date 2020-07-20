package CS_Note.first.swordToOffer.No_01_20;

public class No14 {

    public static void main(String[] args) {
        System.out.println(integerBreak(4));
    }

    public static int integerBreak(int n) {
        if (n < 4)
            return n-1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j <= i / 2; j++) {
                int i1 = dp[j] * dp[i - j];
                if (i1 > dp[i])
                    dp[i] = i1;
            }
        }
        return dp[n];
    }
}
