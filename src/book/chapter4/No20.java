package book.chapter4;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长连续子序列
 */
public class No20 {
    public static int longestSeq(int[] arr) {
        int max = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                if (map.containsKey(arr[i] - 1)) {
                    max = Math.max(max, merge(map, arr[i] - 1, arr[i]));
                }
                if (map.containsKey(arr[i] + 1)) {
                    max = Math.max(max, merge(map, arr[i], arr[i] + 1));
                }
            }
        }
        return max;
    }

    private static int merge(Map<Integer, Integer> map, int less, int more) {
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) + 1;
        int len = right - left + 1;
        map.put(left, len );
        map.put(right, len);
        return len;
    }
}
