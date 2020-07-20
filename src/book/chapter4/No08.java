package book.chapter4;

import java.util.Arrays;

public class No08 {
    public static int maxEnvelope(int[][] matrix) {
        Arrays.sort(matrix, (o1, o2) -> o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o1[1] - o2[1]);
        int[] ends = new int[matrix.length];
        int[] dp = new int[matrix.length];
        ends[0] = matrix[0][1];
        int right = 0, l = 0, m = 0, r = 0;
        // 求从 0 - right 的最长递增子序列
        for (int i = 0; i < matrix.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (matrix[i][1] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[1] = matrix[i][1];
            dp[i] = l + 1;
        }
        return right + 1;
    }
}
