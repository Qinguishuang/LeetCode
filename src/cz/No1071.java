package cz;

import java.util.Arrays;

public class No1071 {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                String tmp = str1.substring(0, i);
                if (str1.split(tmp).length == 0 && str2.split(tmp).length == 0) {
                    return tmp;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(Arrays.toString(s.split("abc")));
    }
}
