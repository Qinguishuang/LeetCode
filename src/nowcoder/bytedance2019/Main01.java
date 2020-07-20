package nowcoder.bytedance2019;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            StringBuffer s = new StringBuffer(sc.nextLine());
            for (int j = 2; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j - 1) && s.charAt(j - 1) == s.charAt(j - 2)) {
                    s.deleteCharAt(j);
                    j --;
                } else if (isDoubleStr(s, j)) {
                    s.deleteCharAt(j);
                    j --;
                }
            }
            System.out.println(s);
        }
    }

    private static boolean isDoubleStr(StringBuffer s, int j) {
        if (j - 3 < 0)
            return false;
        if (s.charAt(j) == s.charAt(j - 1) && s.charAt(j - 2) == s.charAt(j - 3))
            return true;
        else
            return false;
    }
}
