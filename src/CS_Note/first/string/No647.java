package CS_Note.first.string;

public class No647 {
    /**
     * 中心扩展法
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += countSegment(s, i, i);
            ans += countSegment(s, i, i + 1);
        }
        return ans;
    }

    public int countSegment(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) {
            count++;
        }
        return count;
    }

    /**
     * 动态规划
     */
    public int countSubstrings2(String s) {
        int len = s.length();
        if (len <= 1) return len;
        boolean[][] dp = new boolean[len][len];
        int i, j;
        int row, column;
        boolean current = false;
        int count = 0;
        for (i = 0; i < len; i++) {
            dp[i][i] = true;
            count++;
        }
        for (i = 1; i < len; i++) {
            for (j = 0; j <= len - i - 1; j++) {
                row = j;
                column = i + j;
                current = (s.charAt(row) == s.charAt(column));
                if (current && (i == 1 || dp[row + 1][column - 1])) {
                    dp[row][column] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        No647 n = new No647();
        System.out.println(n.countSubstrings2("abbc"));
    }

}
