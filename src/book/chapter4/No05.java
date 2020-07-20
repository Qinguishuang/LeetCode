package book.chapter4;

/**
 * 换钱方法数
 */
public class No05 {
    public static int coin(int[] arr, int aim) {
        int[] dp = new int[aim + 1];
        dp[0] = 1;
        for (int i = 1; i <= aim; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i - arr[j] >= 0) {
                    dp[i] += dp[i - arr[j]];
                }
            }
        }
        return dp[aim];
    }
}
