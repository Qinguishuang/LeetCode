package CS_Note.first.dp;

import java.util.Arrays;

public class No064 {
    /**
     * 数组中等差递增子区间的个数
     * <p>
     * dp[i] 以第A[i]结尾的等差数列个数
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <= 2)
            return 0;
        int[] dp = new int[A.length + 2];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return Arrays.stream(dp).sum();
    }
}