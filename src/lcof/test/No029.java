package lcof.test;

import java.util.ArrayList;
import java.util.List;

public class No029 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[0];
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();
        while (true) {
            for (int i = l; i <= r; i++) { // 从左到右
                ans.add(matrix[u][i]);
            }
            if (++u > d) break;
            for (int i = u; i <= d; i++) { // 从上到下
                ans.add(matrix[i][r]);
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) { // 从右到左
                ans.add(matrix[d][i]);
            }
            if (--d > u) break;
            for (int i = d; i >= u; i--) { // 从下到上
                ans.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        ans.forEach(System.out::print);
        return new int[0];
    }

    public static void main(String[] args) {
        No029 n = new No029();
        int[][] matrix = {{1, 2, 3, 4}, { 5, 6, 7, 8}, {9, 10, 11, 12}};
        n.spiralOrder(matrix);
    }

}
