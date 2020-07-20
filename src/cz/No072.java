package cz;

/**
 * 编辑距离
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * horse -> ros
 *     r  o  s
 *   0 1  2  3
 * h 1
 * r 2
 * o 3
 * r 4
 * e 5
 * 插入： dp[i][j - 1] + 1
 * 删除： dp[i - 1][j] + 1
 * 替换： dp[i - 1][j - 1] + 1
 */
public class No072 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                 // 插入： dp[i][j - 1] + 1
                 // 删除： dp[i - 1][j] + 1
                 // 替换： dp[i - 1][j - 1] + 1
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[word1.length() - 1][word2.length() - 1];
    }
}
