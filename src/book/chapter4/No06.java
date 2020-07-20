package book.chapter4;

/**
 * 打气球
 */
public class No06 {
    /**
     * 打爆 arr[L...R] 之间的气球
     */
    public static int maxScore(int[] arr, int L, int R) {
        if (L == R)
            return arr[L - 1] * arr[L] * arr[R + 1];
        // 最后打两边
        int max = Math.max(
                arr[L - 1] * arr[L] * arr[R + 1] + maxScore(arr, L + 1, R), // 最后打爆 arr[L]
                arr[L - 1] * arr[R] * arr[R + 1] + maxScore(arr, L, R - 1) // 最后打爆 arr[R]
        );
        // 最后打中间
        for (int i = L + 1; i < R; i++) {
            max = Math.max(
                    max,
                    arr[L - 1] * arr[i] * arr[R + 1] + maxScore(arr, L, i - 1) + maxScore(arr, i + 1, R)
            );
        }
        return max;
    }

    public static int maxCoin(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];
        int[] tmp = new int[arr.length + 1];
        tmp[0] = 1;
        tmp[arr.length] = 1;
        System.arraycopy(arr, 0, tmp, 1, arr.length);
        int[][] dp = new int[tmp.length][tmp.length];
        // 先计算对角线
        for (int i = 1; i <= arr.length; i++) {
            dp[i][i] = tmp[i - 1] * tmp[i] * tmp[i + 1];
        }
        // 从最后一行开始从下往上计算
        for (int L = arr.length; L > 0; L--) {
            for (int R = L + 1; R <= arr.length; R++) {
                int finalL = tmp[L - 1] * tmp[L] * tmp[R + 1] + dp[L + 1][R];
                int finalR = tmp[L - 1] * tmp[R] * tmp[R + 1] + dp[L][R - 1];

                dp[L][R] = Math.max(finalL, finalR);
                for (int i = L + 1; i < R; i++) {
                    dp[L][R] = Math.max(dp[L][R], tmp[L - 1] * tmp[i] * tmp[R + 1] + dp[L][i - 1] + dp[i + 1][R]);
                }
            }
        }
        return dp[1][arr.length];
    }

    public static void process(String[] arr) {
        int[] tmp = new int[arr.length + 1];
        tmp[0] = 1;
        tmp[arr.length] = 1;
        System.arraycopy(arr, 0, tmp, 1, arr.length);
        maxScore(tmp, 1, arr.length);

        // Collections.synchronizedMap()
    }
}
