package CS_Note.first.swordToOffer.No_41_60;

import java.util.Arrays;

/**
 * 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。
 * 一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class No46 {

    public static void main(String[] args) {
        No46 n = new No46();
        System.out.println(n.numDecodings("17"));
    }

    /**
     * f(n) = f(n - 1) + f(n - 2)
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1] = (s.charAt(i) == '0' ? 0 : dp[i]);
            if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
                dp[i + 1] += dp[i - 1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
}
