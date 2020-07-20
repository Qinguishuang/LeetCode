package CS_Note.first.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class No451 {

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        // 统计字符出现次数
        Map<Character, Integer> frequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        // 创建桶
        ArrayList<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char c : frequency.keySet()) {
            int f = frequency.get(c);
            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(c);
        }
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (char c : buckets[i]) {
                // stringBuffer.append(String.valueOf(c).repeat(i));
                for (int j = 0; j < i; j++) {
                    stringBuffer.append(c);
                }
            }
        }
        return stringBuffer.toString();
    }

}
