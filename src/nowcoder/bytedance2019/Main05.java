package nowcoder.bytedance2019;

import java.util.Scanner;

public class Main05 {
    private static int minCost = Integer.MAX_VALUE;
    private static int visitedNum = 0;
    private static boolean[] isVisited;
    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        isVisited = new boolean[n + 1];
        isVisited[1] = true;
        find(1, n, 0);
        System.out.println(minCost);
    }

    /**
     * 暴力查找所有情况
     */
    private static void find(int i, int n, int preCost) {
        if (visitedNum == n) {
            if (preCost + matrix[i][1] < minCost) {
                minCost = preCost + matrix[i][1];
            }
        }

        for (int j = 1; j <= n; j++) {
            if (!isVisited[j]) {
                preCost += matrix[i][j];
                if (preCost > minCost) {
                    preCost -= matrix[i][j];
                    continue;
                }
                isVisited[j] = true;
                visitedNum++;

                find(j, n, preCost);

                isVisited[j] = false;
                visitedNum--;
                preCost -= matrix[i][j];
            }
        }
    }

    public static void main02(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n][1 << (n - 1)];
        for (int i = 0; i < n; i++) {
            dp[i][0] = map[i][0];
        }
        for (int i = 1; i < 1 << (n - 1); i++) { // 遍历所有的集合
            for (int j = 0; j < n; j++) { // 选定一个起点城市
                dp[j][i] = Integer.MAX_VALUE >> 1; // 防止计算时越界
                if (self(j, i)) // 判断城市j是否出现在集合中
                    continue;
                for (int k = 0; k < n; k++) {// 依次枚举子问题
                    if (visit(k, i)) {
                        int op = unmark(i, k);
                        dp[j][i] = Math.min(dp[j][i], dp[k][op] + map[j][k]);
                    }
                }
            }
        }
        System.out.println(dp[0][1 << (n - 1) - 1]);
    }

    private static boolean self(int city, int i) {
        return (i & (1 << (city - 1))) != 0;
    }

    private static boolean visit(int city, int p) {
        return self(city, p);
    }

    private static int unmark(int p, int city) {
        return (p & (~(1 << (city - 1))));
    }
}
