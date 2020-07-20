package book.chapter4;

import java.util.Arrays;

/**
 * 最长公共子串
 */
public class No11 {
    public static String longestSub(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] +1;
                } else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (dp[i +1][j + 1] > max) {
                    max = dp[i +1][j + 1];
                    index = i +1;
                }
            }
        }
        System.out.println(max);
        System.out.println(index);
        System.out.println(s.substring(index - max, index));
        System.out.println(Arrays.deepToString(dp));
        return "";
    }

    public static void main(String[] args) {
        System.out.println(longestSub("a123f", "1234"));
    }
}
