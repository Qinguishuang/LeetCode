package CS_Note.first.greedy;

public class No392 {
    /**
     * s = "abc", t = "ahbgdcadfartehgiohib"
     */
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            index = s.indexOf(s.charAt(i), index);
            if (index == -1)
                return false;
        }
        return true;
    }
}
