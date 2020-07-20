package CS_Note.first.search;

public class No200 {

    private int m, n;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int count = 0;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0')
            return ;
        grid[r][c] = '0';
        for (int[] direction : directions) {
            dfs(grid, r + direction[0], c + direction[1]);
        }
    }
}
