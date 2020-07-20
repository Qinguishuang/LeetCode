package CS_Note.first.array;

public class No566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0 || nums.length * nums[0].length != r * c) {
            return nums;
        }
        int[][] ans = new int[r][c];
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                ans[num / r][num % c] = nums[i][j];
                num++;
            }
        }
        return ans;
    }
}
