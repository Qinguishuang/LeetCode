package CS_Note.first.dp;

import java.util.Arrays;

public class No416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        //动态规划，背包问题，从nums中选择一部分数字组合，填满容量为sum/2的背包
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        } else {
            sum = sum / 2;
        }

        int[][] dp = new int[nums.length + 1][sum + 1];
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                // if (nums[i] == j || j >= nums[i] && (dp[i - 1][j] == 1 || dp[i - 1][j - nums[i]] == 1))
                if (nums[i - 1] == j || (nums[i - 1] <= j && (dp[i - 1][j] == 1 || dp[i - 1][j - nums[i - 1]] == 1)))
                    dp[i][j] = 1;
            }
        }
        return dp[nums.length][sum] == 1;
    }

    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        //动态规划，背包问题，从nums中选择一部分数字组合，填满容量为sum/2的背包
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        } else {
            sum = sum / 2;
        }

        int[] dp = new int[sum + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= sum; j--) {
                if (dp[i] == 1 || dp[j - nums[i]] == 1){
                        dp[i] = 1;
                }
            }
        }
        return dp[sum] == 1;
    }

    public static void main(String[] args) {
        No416 n = new No416();
        int[] nums = {1, 2, 5, 2};
        System.out.println(n.canPartition(nums));
    }
}