package CS_Note.first.greedy;

import java.util.Arrays;

public class No455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            // 可以满足, 都增加
            if (g[i] <= s[j]) {
                i += 1;
            }
            // 孩子胃口大, 饼干增加
            j += 1;
        }
        return i;
    }
}
