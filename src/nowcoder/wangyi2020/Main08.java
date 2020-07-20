package nowcoder.wangyi2020;

import java.util.Scanner;

public class Main08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++)
            x[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            y[i] = sc.nextInt();
        int maxShoot = 0;
        if (n < 4)
            maxShoot = n;
        for (int i = 0; i < n; i++) { // 选第一个点
            for (int j = i + 1; j < n; j++) { //选第二个点
                int x1 = x[j] - x[i]; // 计算第一条线斜率
                int y1 = y[j] - y[i];
                for (int k = 0; k < n; k++) { // 选第三个点
                    if (k == i || k == j) // 点不能重复
                        continue;
                    int count = 3;
                    for (int l = 0; l < n; l++) { // 选第四个点
                        if (l == i || l == j || l == k)
                            continue;
                        int x2 = x[l] - x[k];
                        int y2 = y[l] - y[k]; // 第二条线斜率
                        int x3 = x[l] - x[i];
                        int y3 = y[l] - y[i]; // 第三条线斜率
                        // 如果：第三条线与第一条线平行(重合) 或 与第二条线垂直
                        if (x1 * x2 + y1 * y2 == 0 || x1 * y3 == x3 * y1)
                            count++;
                    }
                    maxShoot = Math.max(maxShoot, count);
                }
            }
        }
        System.out.println(maxShoot);
    }

}
