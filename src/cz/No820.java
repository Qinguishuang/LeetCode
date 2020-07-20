package cz;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No820 {
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        Set<String> good = new HashSet<>(Arrays.asList(words));
        for (String s : words) {
            for (int i = 1; i < s.length(); i++) {
                good.remove(s.substring(i));
            }
        }
        int ans = 0;
        for (String g : good) {
            ans += g.length() + 1;
        }
        return ans;
    }
}
