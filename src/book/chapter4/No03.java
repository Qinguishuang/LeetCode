package book.chapter4;

public class No03 {

    public static int minCoin(int[] arr, int index, int aim) {
        if (index == arr.length)
            return aim == 0 ? 0 : -1;
        int res = -1;
        for (int i = 0; aim - i * arr[i] >= 0; i++) {
            int next = minCoin(arr, index + 1, aim - i * arr[i]);
            if (next != -1) // 后面可以找开
                res = (res == -1 ? next + i : Math.min(res, next + i));
        }
        return res;
    }

    public static int inCoinDp(int[] arr, int aim) {
        int[] dp = new int[aim + 1];
        for (int i = 1; i <= aim; i++) {
            dp[i] = i + 1;
            for (int j = 0; j < arr.length; j++) {
                if (i - arr[i] >= 0) {
                    dp[i] = Math.min(dp[i], dp[arr[i]] + dp[aim - arr[i]]) + 1;
                }
            }
        }
        return dp[aim] > aim ? -1 : dp[aim];
    }


    public static void main(String[] args) {
        System.out.println(minCoin(new int[]{5, 2, 3}, 0, 20));
    }
}
