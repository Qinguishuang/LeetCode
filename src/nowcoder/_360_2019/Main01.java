package nowcoder._360_2019;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] pos = new long[n][2];
        long min_x = Long.MAX_VALUE, min_y = Long.MAX_VALUE; // 找x最大, y最小
        long max_x = Long.MIN_VALUE, max_y = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            pos[i][0] = sc.nextLong();
            pos[i][1] = sc.nextLong();
            if (min_x > pos[i][0]) {
                min_x = pos[i][0];
            }
            if (max_x < pos[i][0]) {
                max_x = pos[i][0];
            }

            if (max_y < pos[i][1]) {
                max_y = pos[i][1];
            }
            if (min_y > pos[i][1]) {
                min_y = pos[i][1];
            }
        }
        System.out.println((long) Math.pow(Math.max((max_x - min_x), (max_y - min_y)), 2));
    }
}
