package book.chapter4;

/**
 * 纸牌博弈问题
 */
public class No18 {

    public static int winDp(int[] arr) {
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }

    public static int win(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    /**
     * 先手
     */
    public static int f(int[] arr, int i, int j) {
        if (i == j)
            return arr[i];
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    /**
     * 后手
     */
    public static int s(int[] arr, int i, int j) {
        if (i == j)
            return 0;
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 10, 4};
        System.out.println(win(arr));
    }
}
