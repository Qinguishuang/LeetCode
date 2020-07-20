package CS_Note.first.dp;

import java.util.Arrays;

public class No494 {
    /**
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     */
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = Arrays.stream(nums).sum() + S;
        if (sum % 2 == 1)
            return 0;
        else
            sum = sum / 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        No494 n = new No494();
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(n.findTargetSumWays(nums, 3));
    }
}
