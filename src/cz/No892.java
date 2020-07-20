package cz;

public class No892 {
    public int surfaceArea(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int blocks = 0;
        int cover = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                blocks += grid[i][j];
                if (grid[i][j] > 1) { // 当前位置，上下两个面被覆盖
                    cover += grid[i][j] - 1;
                }
                if (i > 0) { // 上一行同一列覆盖面
                    cover += Math.min(grid[i - 1][j], grid[i][j]);
                }
                if (j > 0) { // 前一列同一行覆盖面
                    cover += Math.min(grid[i][j - 1], grid[i][j]);
                }
            }
        }
        return blocks * 6 - cover * 2;
    }
}
