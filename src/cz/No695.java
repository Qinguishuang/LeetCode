package cz;

public class No695 {
    private int ans = 0;

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(backTracing(grid, isVisited, i, j, 0), ans);
            }
        }
        return ans;
    }

    private int backTracing(int[][] grid, boolean[][] isVisited, int x, int y, int area) {
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && !isVisited[x][y] && grid[x][y] == 1) {
            area++;
            isVisited[x][y] = true;
            area += backTracing(grid, isVisited, x + 1, y, 0);
            area += backTracing(grid, isVisited, x - 1, y, 0);
            area += backTracing(grid, isVisited, x, y + 1, 0);
            area += backTracing(grid, isVisited, x, y - 1, 0);
            return area;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        No695 n = new No695();
        int[][] grid = {{1, 1}, {1, 0}};
        System.out.println(n.maxAreaOfIsland(grid));
    }
}
