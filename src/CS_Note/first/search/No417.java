package CS_Note.first.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No417 {

    private int[][] matrix;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }
        this.matrix = matrix;
        int[][] first = new int[matrix.length][matrix[0].length];
        int[][] second = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            dfs(first, i, 0);
            dfs(second, i, matrix[0].length - 1);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dfs(first, 0, i);
            dfs(second, matrix.length - 1, i);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (first[i][j] == 1 && second[i][j] == 1)
                    ans.add(Arrays.asList(i, j));
            }
        }
        return ans;
    }

    public void dfs(int[][] f, int r, int c) {
        if (f[r][c] == 1) {
            return;
        }
        f[r][c] = 1;
        if (r - 1 >= 0 && matrix[r][c] <= matrix[r - 1][c])
            dfs(f, r - 1, c);
        if (r + 1 < matrix.length && matrix[r][c] <= matrix[r + 1][c])
            dfs(f, r + 1, c);
        if (c - 1 >= 0 && matrix[r][c] <= matrix[r][c - 1])
            dfs(f, r, c - 1);
        if (c + 1 < matrix[0].length && matrix[r][c] <= matrix[r][c + 1])
            dfs(f, r, c + 1);
    }
}
