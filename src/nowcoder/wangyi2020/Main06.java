package nowcoder.wangyi2020;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 修改长度为1时, 最长公共子序列最长
 * 每次拿一个遍历插入
 */
public class Main06 {
    private static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        getSequence(str);
        System.out.println(set.size() - 1);
    }

    private static void getSequence(String str) {
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sBuffer = new StringBuilder(str);
            char c = sBuffer.charAt(i);
            sBuffer.deleteCharAt(i);
            for (int j = 0; j < str.length(); j++) {
                sBuffer.insert(j, c);
                if (isLegal(sBuffer.toString())) {
                    set.add(sBuffer.toString());
                }
                sBuffer.deleteCharAt(j);
            }
        }
    }

    private static boolean isLegal(String s) {
        int left = s.length() / 2;
        int right = s.length() / 2;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left--;
            } else {
                right--;
            }
            if (right < left)
                return false;
        }
        return true;
    }

}
