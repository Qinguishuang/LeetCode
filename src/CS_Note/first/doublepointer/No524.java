package CS_Note.first.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class No524 {

    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String string : d) {
            int l1 = string.length();
            int l2 = longestWord.length();
            if (l1 < l2 || (l1 == l2 && longestWord.compareTo(string) < 0)) {
                continue;
            }
            if (isSubStr(s, string)) {
                longestWord = string;
            }
        }
        return longestWord;
    }

    private boolean isSubStr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        List<String> l = new ArrayList<>();
        // 到原串第 i 个字符为止添加或者移除第 i 个字符所能生成的字符串
        generate(s, "", 0, l);
        l.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -Integer.compare(o1.length(), o2.length());
            }
        });
        System.out.println(Arrays.toString(l.toArray()));
    }

    private static void generate(String s, String str, int i, List<String> l) {
        if (i == s.length())
            l.add(str);
        else {
            generate(s, str + s.charAt(i), i + 1, l); // 添加第i个
            generate(s, str, i + 1, l); // 不添加第i个
        }
    }

}
