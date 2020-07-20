package CS_Note.first.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class No242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] s1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            s1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            s1[t.charAt(i) - 'a']--;
            if (s1[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        // for(Map.Entry<Character, Integer> entry: map1.entrySet()) {
        //
        // }
        Iterator iterator = null;
        if (map1.size() >= map2.size()) {
            iterator = map1.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                if (map2.get(entry.getKey()) != entry.getValue()) {
                    return false;
                }
            }
        } else {
            iterator = map2.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                if (map1.get(entry.getKey()) != entry.getValue()) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        No242 n = new No242();
        System.out.println(n.isAnagram2("abc", "bca"));
    }
}
