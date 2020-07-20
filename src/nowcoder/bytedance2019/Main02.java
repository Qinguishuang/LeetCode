package nowcoder.bytedance2019;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] position = new int[n];
        for (int i = 0; i < n; i++) {
            position[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (position[j] <= position[i] + d) {
                    count++;
                }
            }

            if (count >= 2) {
                ans += (count * (count - 1)) / 2 % 99997867;
            }
        }
        System.out.println(ans);
    }
}
