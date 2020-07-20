package book.chapter4;

/**
 * 判断交错字符串
 * AB, 12  ->  A12B
 */
public class No14 {
    public static boolean isCross(String s, String t, String aim) {
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) != aim.charAt(i - 1)) {
                break; // 如果一个不相等， 下面的都不相等
            }
            dp[i][0] = true;
        }
        for (int i = 1; i <= t.length(); i++) {
            if (t.charAt(i - 1) != aim.charAt(i - 1)) {
                break;
            }
            dp[0][i] = true;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == aim.charAt(i + j - 1) && dp[i - 1][j] ||
                        t.charAt(j - 1) == aim.charAt(i + j - 1) && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[s.length()][t.length()];
    }
}
