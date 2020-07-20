package nowcoder.wangyi2020;

import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if (n < 3)
            System.out.println(0);
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j == i + 1) {
                    if (i == 0) {
                        dp[i][j] = 0; // dp[0][1] 第一个人唱第一个， 第二个人唱第二个
                    } else { // 换人  dp[2][3] 第一个人唱第三个， 第二个人唱第四个
                        // dp[3][4] 可以由dp[0][3], dp[1][3], dp[2][3]
                        int result = Integer.MAX_VALUE;
                        for (int k = 0; k < i; k++) {
                            int curr = dp[k][i] + Math.abs(nums[j] - nums[k]);
                            result = Math.min(result, curr);
                        }
                        int res = 0; // 前面全都是一个人唱的
                        for (int k = 1; k < j; k++) {
                            res = res + Math.abs(nums[k] - nums[k - 1]);
                        }
                        dp[i][j] = Math.min(res, result);
                    }
                } else { // 不换人， 一人连着唱两个
                    dp[i][j] = dp[i][j - 1] + Math.abs(nums[j] - nums[j - 1]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(dp[i][n - 1], ans);
        }
        System.out.println(ans);
    }

}
