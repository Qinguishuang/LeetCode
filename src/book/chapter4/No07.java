package book.chapter4;

/**
 * 最长递增子序列 O(n ^ 2)
 */
public class No07 {
    public int[] longest(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        // arr [2, 1, 5, 3, 6, 4, 8, 9, 7]
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j]) + 1;
                }
            }
        }
        return getArray(arr, dp);
    }

    /**
     * 二分法
     */
    public int[] longest2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] end = new int[arr.length];
        end[0] = arr[0];
        dp[0] = 1;
        int right = 0, l = 0, r = 0, m = 0;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > end[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            end[l] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    /**
     * 根据长度获取递增数组
     */
    public int[] getArray(int[] arr, int[] dp) {
        // dp [1, 1, 2, 2, 3, 3, 4, 5, 4]
        int index = 0; // 找到最大值的位置
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > dp[index]) {
                index = i;
            }
        }
        int num = dp[index]; // 数组的长度
        int[] ans = new int[num];
        ans[--num] = arr[index]; // 放入最后的最大值
        for (int i = index - 1; i >= 0; i--) {
            if (dp[index] - dp[i] == 1 && arr[i] < arr[index]) {
                ans[--num] = arr[i];
                index = i;
            }
        }
        return ans;
    }


}
