package CS_Note.first.string;

public class No696 {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int ans = 0;
        int last = 0;
        int curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                last = curr;
                curr = 1;
            }
            if (last >= curr) {
                ans++;
            }
        }
        return ans;
    }
}
