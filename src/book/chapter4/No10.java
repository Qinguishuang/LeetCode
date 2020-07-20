package book.chapter4;

import java.util.Arrays;

/**
 * 最长公共子序列
 */
public class No10 {
    public static String longestSequence(String t, String s) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        int num = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[i + 1][j + 1] == num) {
                    num++;
                    stringBuilder.append(s.charAt(j));
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[t.length()][s.length()]);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestSequence("1s2r34g5", "1246"));
    }
}
