package lcof.No_21_40;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class No38 {
    Set<String> set = new HashSet<>();

    public String[] permutation(String s) {
        if (s == null || s.length() == 0)
            return new String[0];
        StringBuilder sb = new StringBuilder(s);
        dfs(sb, 0);
        String[] ans = new String[set.size()];
        return set.toArray(ans);
    }

    private void dfs(StringBuilder sb, int i) {
        if (sb.length() == i) {
            set.add(sb.toString());
            return;
        }
        for (int j = i; j < sb.length(); j++) {
            swap(sb, i, j);
            dfs(sb, i + 1);
            swap(sb, i, j);
        }
    }

    private void swap(StringBuilder s, int i, int j) {
        char c = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, c);
    }

    public static void main(String[] args) {
        No38 n = new No38();
        System.out.println(Arrays.toString(n.permutation("abc")));
    }
}
