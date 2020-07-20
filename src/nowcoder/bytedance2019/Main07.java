package nowcoder.bytedance2019;

import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i++) {
            ans = (ans + h[i] + 1) / 2;
        }
        System.out.println(ans);
    }
}
