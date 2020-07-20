package lcof.No_01_20;

public class No13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] isVisited = new boolean[m][n];
        backTracing(0, 0, m, n, k, isVisited);
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isVisited[i][j])
                    count++;
            }
        }
        return count;
    }

    private void backTracing(int x, int y, int rows, int cols, int k, boolean[][] isVisited) {
        if (x >= 0 &&
                x < rows &&
                y >= 0 &&
                y < cols &&
                !isVisited[x][y] &&
                canGet(x, y, k)
        ) {
            isVisited[x][y] = true;
            backTracing(x + 1, y, rows, cols, k, isVisited);
            backTracing(x - 1, y, rows, cols, k, isVisited);
            backTracing(x, y + 1, rows, cols, k, isVisited);
            backTracing(x, y - 1, rows, cols, k, isVisited);
        }
    }

    private boolean canGet(int x, int y, int k) {
        int ans = 0;
        while (x > 0) {
            ans += (x % 10);
            x /= 10;
        }
        while (y > 0) {
            ans += (y % 10);
            y /= 10;
        }
        return ans <= k;
    }
}
