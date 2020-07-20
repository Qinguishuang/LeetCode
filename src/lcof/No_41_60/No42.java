package lcof.No_41_60;

public class No42 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int ans = Integer.MIN_VALUE; // 记录最大值
        int now = 0; // 记录变化
        for (int i = 0; i < nums.length; i++) {
            now = now + nums[i];
            if (now > ans) {
                ans = now;
            }
            if (now < 0) {
                now = 0;
            }

        }
        return ans;
    }
}
