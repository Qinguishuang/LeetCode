package nowcoder.bytedance2019;

import java.util.HashMap;
import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int times = sc.nextInt(); // 次数
        while (times-- > 0) {
            HashMap<String, Integer> mem = new HashMap<>();
            HashMap<String, Integer> tmp = new HashMap<>();
            int m = sc.nextInt(); // 行数
            int max = 1;
            for (int i = 0; i < m; i++) {
                tmp.clear();
                int n = sc.nextInt(); // 特征个数
                for (int j = 0; j < n; j++) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    String key = x + " " + y;
                    tmp.put(key, mem.getOrDefault(key, 0) + 1);
                    max = Math.max(max, tmp.get(key));
                }
                mem.clear();
                mem.putAll(tmp);
            }
            System.out.println(max);
        }
    }


}
