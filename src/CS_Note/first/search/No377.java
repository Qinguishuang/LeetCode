package CS_Note.first.search;

public class No377 {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < 0)
            return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num: nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        No377 n = new No377();
        n.combinationSum4(new int[]{1, 2, 3}, 4);
    }
}
