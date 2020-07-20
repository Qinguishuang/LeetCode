package book.chapter4;

import java.net.SocketTimeoutException;
import java.util.Arrays;

public class No19 {
    public static int jump(int[] arr) {
        int jump = 0, cur = 0, next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }

    public static int j(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length && j <= arr[i] + i; j++) {
                if (dp[j] != 0) {
                    dp[j] = Math.min(dp[i] + 1, dp[j]);
                } else {
                    dp[j] = dp[i] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 1, 4};
        System.out.println(j(arr));
    }
}
