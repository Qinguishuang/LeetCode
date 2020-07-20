package lcof.No_41_60;

import java.util.Arrays;

public class No50 {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return ' ';
        int[] c = new int[26];
        Arrays.fill(c, -1);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (c[index] == -1) { // 没有出现过，记录坐标
                c[index] = i;
            } else { // 出现过了
                c[index] = -2;
            }
        }
        int min = s.length();
        for (int i = 0; i < c.length; i++) { // 寻找第一次出现，并且出现一次的字符
            if (c[i] > -1 && c[i] < min) {
                min = c[i];
            }
        }
        if (min == s.length())
            return ' ';
        else
            return s.charAt(min);
    }

    public static void main(String[] args) {
        No50 n = new No50();
        System.out.println(n.firstUniqChar("leetcode"));
    }
}
