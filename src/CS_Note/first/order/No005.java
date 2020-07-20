package CS_Note.first.order;

public class No005 {

    public String longestPalindrome2(String s) {
        boolean[][] p = new boolean[s.length()][s.length()];
        int maxLen = 0;
        String ans = "";
        for (int len = 1; len <= s.length(); len++) { // 遍历所有的长度
            for (int start = 0; start < s.length(); start++) {
                int end = start + len - 1;
                if (end >= s.length()) { // 下标越界
                    break;
                }
                p[start][end] = (len == 1 || (len == 2 && s.charAt(start) == s.charAt(start + 1))
                        || (p[start + 1][end - 1] && s.charAt(start) == s.charAt(end)));
                if (p[start][end] && len > maxLen) {
                    ans = s.substring(start, end + 1);
                    maxLen = ans.length();
                }
            }
        }
        return ans;
    }

    public String longestPalindrome(String s) {
        String ans = "";
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) { // 长度
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][i - 1]));
                if (dp[i][j] && j - i + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No005 n = new No005();
        System.out.println(n.longestPalindrome2("abcbd"));
    }


}
