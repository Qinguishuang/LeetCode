package CS_Note.first.greedy;

public class No053 {
    /**
     * 子数组最大的和
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (ans > 0) {
                ans = ans + nums[i];
            } else {
                ans = nums[i];
            }
            max = Math.max(max, ans);
        }
        return max;
    }
}