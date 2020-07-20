package book.chapter4;

import java.util.HashMap;

public class No12 {
    public static int maxSplit(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int[] dp = new int[arr.length];
        // 存储 (某一个异或和, 上次出现位置)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        dp[0] = (arr[0] == 0 ? 1 : 0);
        map.put(arr[0], 0);
        int eor = arr[0]; // 异或和
        for (int i = 1; i < arr.length; i++) {
            eor ^= arr[i];
            if (map.containsKey(eor)) {
                int preIndex = map.get(eor); // 上一次出现位置, -1:异或为0, 第一次出现
                dp[i] = (preIndex == -1 ? 1 : dp[preIndex] + 1); // 异或和数组为零的个数
            }
            dp[i] = Math.max(dp[i - 1], dp[i]);
            map.put(eor, i);
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {

    }
}
