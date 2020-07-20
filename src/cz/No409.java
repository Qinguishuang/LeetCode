package cz;

import java.util.Map;
import java.util.stream.Collectors;

public class No409 {

    public int longestPalindrome_(String s) {
        Map<Integer, Integer> count = s.chars().boxed()
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
        int ans = count.values().stream().mapToInt(i -> i - (i & 1)).sum();
        return ans < s.length() ? ans + 1 : ans;
    }

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int[] count = new int[52];
        int ans = 0;
        boolean odd = false;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp >= 'a' && tmp <= 'z') {
                count[tmp - 'a']++;
            } else {
                count[tmp - 'A' + 26]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 == 0) {
                ans += count[i];
            } else {
                odd = true;
                if (count[i] - 1 > 0) {
                    ans += count[i] - 1;
                }
            }
        }
        if (odd) {
            ans++;
        }
        return ans;
    }
}
