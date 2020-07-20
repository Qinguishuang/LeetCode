package book.chapter5;

import java.util.HashMap;

public class No01 {
    public static boolean isChange(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            } else {
                int num = map.get(t.charAt(i));
                if (num - 1 < 0)
                    return false;
                map.put(t.charAt(i), num - 1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isChange("abc", "bca"));
    }
}
