package CS_Note.first.swordToOffer.No_61_80;

import java.util.Arrays;

public class No61 {
    /**
     * 五张牌，其中大小鬼为癞子，牌面为 0。判断这五张牌是否能组成顺子。
     */
    public boolean isContinuous(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        Arrays.sort(nums);
        int count = 0;
        for (int num : nums) {
            if (num == 0)
                count++;
        }
        for (int i = count + 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 1) {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

