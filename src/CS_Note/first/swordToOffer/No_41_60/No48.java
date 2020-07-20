package CS_Note.first.swordToOffer.No_41_60;

import java.util.Arrays;

public class No48 {
    /**
     * 输入一个字符串（只包含 a~z 的字符），求其最长不含重复字符的子字符串的长度。
     * 例如对于 arabcacfr，最长不含重复字符的子字符串为 acfr，长度为 4。
     * <p>
     * <p>
     * 动态规划
     * 第i个字符没有出现过 f(i) = f(i-1) + 1;
     * 第i个字符出现过:
     * 计算当前字符距离上一次出现的距离d
     * d <= f(i-1) 更新f(i) = d;
     * 否则 f(i) = f(i-1) + 1;
     */
    public int longestSubStringWithoutDuplication(String str) {
        int currLen = 0;
        int maxLen = 0;
        int[] preIndex = new int[26]; // 记录字符上次出现的位置
        Arrays.fill(preIndex, -1);

        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a'; // 当前字符
            int preI = preIndex[c]; // 上次出现的下标
            if (preI == -1 || i - preI > currLen) { // 以前没有出现过 || 上次出现的位置不在当前长度内
                currLen++;
            } else {
                maxLen = Math.max(maxLen, currLen);
                currLen = i - preI;
            }
            preIndex[c] = i;
        }
        maxLen = Math.max(maxLen, currLen);
        return maxLen;
    }

}
