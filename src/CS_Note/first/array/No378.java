package CS_Note.first.array;

public class No378 {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int min = matrix[0][0];
        int max = matrix[matrix.length - 1][matrix[0].length - 1];
        while (min < max) {
            int mid = (min + max) / 2;
            int count = findMid(matrix, mid);
            if (count < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return max;
    }

    public int findMid(int[][] matrix, int mid) {
        // 从第一列最后一个开始向上比较
        int r = matrix.length - 1, c = 0;
        int count = 0;
        while (r >= 0 && c < matrix.length) {
            if (matrix[r][c] <= mid) {
                c++;
                count += r + 1;
            } else {
                r--;
            }
        }
        return count;
    }
}
