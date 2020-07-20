package cz;

import java.util.HashMap;
import java.util.Map;

public class No5368 {
    public int findLucky(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : arr) {
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
            } else {
                map.put(k, 1);
            }
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> tmp: map.entrySet()) {
            if (tmp.getKey().equals(tmp.getValue())) {
                if (ans < tmp.getKey()) {
                    ans = tmp.getKey();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No5368 n = new No5368();
        int[] arr = {2, 2, 2, 3, 3};
        System.out.println(n.findLucky(arr));
    }
}
