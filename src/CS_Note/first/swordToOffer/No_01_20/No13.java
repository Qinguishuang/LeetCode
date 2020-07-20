package CS_Note.first.swordToOffer.No_01_20;

public class No13 {
    /**
     * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
     * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18
     * 。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
     * 请问该机器人能够达到多少个格子？
     */
    public int movingCount(int threshold, int rows, int cols) {
        int[][] visited = new int[rows][cols];
        return solution(0, 0, rows, cols, visited, threshold);

    }

    public int solution(int r, int c, int rows, int cols, int[][] visited, int threshold) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || numSum(r) + numSum(c) > threshold || visited[r][c] == 1) {
            return 0;
        }
        visited[r][c] = 1;
        return solution(r - 1, c, rows, cols, visited, threshold) +
                solution(r + 1, c, rows, cols, visited, threshold) +
                solution(r, c - 1, rows, cols, visited, threshold) +
                solution(r, c + 1, rows, cols, visited, threshold) + 1;
    }

    public int numSum(int i) {
        int ans = 0;
        while (i > 0) {
            ans += i % 10;
            i /= 10;
        }
        return ans;
    }


}

