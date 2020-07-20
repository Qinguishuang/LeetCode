package CS_Note.first.dp;

import java.util.Arrays;

public class No300 {
    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] <= nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 新建数组 cell，用于保存最长上升子序列
     * <p>
     * 如果 cell 中元素都比它小，将它插到最后
     * 否则，用它覆盖掉比它大的元素中最小的那个。
     * 思想就是让 cell 中存储比较小的元素。这样，cell 未必是真实的最长上升子序列，但长度是对的。
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] tail = new int[nums.length];
        int currLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int l = 0, h = currLen;
            // 二分法查找位置, l是插入的位置
            while (l < h) {
                int m = l + (h - l) / 2;
                if (tail[m] < nums[i]) {
                    l = m + 1;
                } else {
                    h = m;
                }
            }
            tail[l] = nums[i];
            // 当前最大, 长度加1
            if (currLen == h) {
                currLen++;
            }
        }
        return currLen;
    }

    public static void main(String[] args) {
        No300 n = new No300();
        // int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {1, 2, 5, 4};
        System.out.println(n.lengthOfLIS2(nums));
    }


}
