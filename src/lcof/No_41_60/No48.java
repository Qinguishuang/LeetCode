package lcof.No_41_60;

import concurrent.PrintABC.SemaphoreTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, ans = 0;
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left)); // 移除掉重复字符之前的所有字符
                left ++;
            } else {
                set.add(s.charAt(right));
                right ++;
                ans = Math.max(ans, set.size());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No48 n = new No48();
        System.out.println(n.lengthOfLongestSubstring("pwwkew"));
    }
}
