package book.chapter4;

public class No02 {
    /**
     * 最小路径和
     */
    public int minSum(int[][] m) {
        int[][] dp = new int[m.length][m[0].length];
        dp[0][0] = m[0][0];
        for (int i = 1; i < m[0].length; i++) {
            dp[0][i] = m[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < m.length; i++) {
            dp[i][0] = m[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < m[0].length; i++) {
            for (int j = 1; j < m.length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[m.length - 1][m[0].length - 1];
    }

    /**
     * 压缩空间
     */
    public int minSum2(int[][] m) {
        int more = Math.max(m.length, m[0].length);
        int less = Math.min(m.length, m[0].length);
        boolean rowMore = (more == m.length); // 记录行是否大于列
        int[] arr = new int[less]; // 选择小的数作为数组长度
        // 如果行多, 从上往下遍历
        // 如果列多, 从左往右遍历
        for (int i = 1; i < less; i++) { // 初始化
            arr[i] = arr[i - 1] + (rowMore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++) {
            arr[0] = arr[i - 1] + (rowMore ? m[i][0] : m[0][i]); // 第一个数字
            for (int j = 1; j < less; j++) {
                // arr[j - 1] 左边  arr[j] 上边
                arr[j] = Math.min(arr[j - 1], arr[j]) + (rowMore ? m[i][j] : m[j][i]);
            }
        }
        return arr[less - 1];
    }
}
