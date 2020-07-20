package CS_Note.first.doublepointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] ans = new char[s.length()];
        int i = 0;
        int j = s.length() - 1;
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!set.contains(ci)) {
                ans[i ++] = ci;
            } else if (!set.contains(cj)) {
                ans[j --] = cj;
            } else {
                ans[i ++] = cj;
                ans[j --] = ci;
            }
        }
        return new String(ans);
    }
}
