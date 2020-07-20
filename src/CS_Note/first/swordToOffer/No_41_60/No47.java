package CS_Note.first.swordToOffer.No_41_60;

/**
 * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。
 * 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。
 */
public class No47 {
    public int getMost(int[][] values) {
        if (values == null || values.length == 0)
            return 0;
        int[][] sum = new int[values.length + 1][values[0].length + 1];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                sum[i + 1][j + 1] = Math.max(sum[i][j + 1], sum[i + 1][j]) + sum[i][j];
            }
        }
        return sum[values.length][values[0].length];
    }
}
