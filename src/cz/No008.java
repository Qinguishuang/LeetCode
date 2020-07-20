package cz;

public class No008 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        int ans = 0;
        boolean isNegative = false;

        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                start = i;
                break;
            }
        }
        if (str.charAt(start) == '-') {
            isNegative = true;
            start++;
        } else if (str.charAt(start) == '+') {
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                if (ans < (Integer.MAX_VALUE - (c - '0')) / 10) {
                    ans = ans * 10 + c - '0';
                } else {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }
        return isNegative ? -ans : ans;
    }
}
