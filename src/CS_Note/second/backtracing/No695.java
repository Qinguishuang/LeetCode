package CS_Note.second.backtracing;

public class No695 {
    private int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] isVisited = null;

    public int maxAreaOfIsland(int[][] grid) {
        isVisited = new boolean[grid.length][grid[0].length];
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxArea = Math.max(backTracing(grid, i, j), maxArea);
            }
        }
        return maxArea;
    }

    private int backTracing(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || isVisited[i][j]) {
            return 0;
        }
        // 已经访问过的不需要再计算, 不需要变回去
        isVisited[i][j] = true;
        int area = 1;
        for (int[] direction : directions) {
            backTracing(grid, i + direction[0], j + direction[1]);
        }
        return area;
    }
}
