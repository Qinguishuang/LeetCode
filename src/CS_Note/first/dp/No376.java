package CS_Note.first.dp;

public class No376 {
    /**
     * 摆动序列
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return 0;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
        }
        return 1 + Math.max(up[up.length - 1], down[down.length - 1]);
    }
}
