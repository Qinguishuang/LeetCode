package lcci;

public class No0103 {
    public String replaceSpaces(String S, int length) {
        char[] ans = new char[length];
        int ansLen = ans.length - 1;
        int len = S.length() - 1;
        while (len > 0) {
            if (S.charAt(len) == ' ') {
                ans[ansLen--] = '0';
                ans[ansLen--] = '2';
                ans[ansLen--] = '%';
            } else {
                ans[ansLen--] = S.charAt(len);
            }
            len--;
        }
        return String.valueOf(ans);
    }
}
