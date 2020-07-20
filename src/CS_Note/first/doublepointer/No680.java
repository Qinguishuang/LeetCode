package CS_Note.first.doublepointer;

public class No680 {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return validPalindrome(s, i, j-1) || validPalindrome(s, i+1, j);
            }
        }
        return true;
    }

    public boolean validPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start ++;
                end --;
            } else {
                return false;
            }
        }
        return true;
    }
}
