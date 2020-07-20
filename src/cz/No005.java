package cz;

public class No005 {
    /**
     * 动态规划
     */
    public String longestPalindrome1(String s) {
        boolean[][] p = new boolean[s.length()][s.length()];
        int maxLen = 0;
        String ans = "";
        for (int len = 0; len <= s.length(); len++) {
            for (int start = 0; start < s.length(); start++) {
                int end = start + len - 1;
                if (end >= s.length()) {
                    break;
                }
                p[start][end] = (len == 1 || (len == 2 && s.charAt(start) == s.charAt(start + 1)) ||
                        (p[start + 1][end - 1] && s.charAt(start) == s.charAt(end)));
                if (p[start][end] && len > maxLen) {
                    ans = s.substring(start, end + 1);
                    maxLen = ans.length();
                }
            }
        }
        return ans;
    }

    /**
     * 中心扩展法
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0)
            return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // 从中间向外扩展
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2); // 总长度
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        // abcdcbe
        // l = 0, r = 6, len=5
        int l = left, r = right;
        // 最后lr指向不相同的两个字符
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

}
