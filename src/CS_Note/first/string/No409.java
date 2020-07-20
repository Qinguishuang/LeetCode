package CS_Note.first.string;

public class No409 {
    public int longestPalindrome(String s) {
        int ans = 0;
        if (s == null || s.length() == 0)
            return ans;
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (int value : count) {
            ans += (value / 2 * 2);
        }
        if (ans < s.length()) {
            return ans + 1;
        } else {
            return ans;
        }

    }
}
