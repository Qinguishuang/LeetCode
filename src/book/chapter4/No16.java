package book.chapter4;

/**
 * 字符串转字母
 */
public class No16 {
    public static int num(String s, int start) {
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        int res = num(s, start + 1);
        if (start + 1 < s.length() && (s.charAt(start) - '0') * 10 + (s.charAt(start + 1)) < 27) {
            res += num(s, start + 1);
        }
        return res;
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1] = (s.charAt(i) == '0' ? 0 : dp[i]); // 单独解码
            if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
                dp[i + 1] += dp[i - 1]; // 和前一项两个数字一起解码
            }
        }
        return dp[s.length()];
    }
}
