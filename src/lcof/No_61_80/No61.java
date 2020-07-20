package lcof.No_61_80;

import java.util.Arrays;

public class No61 {
    /**
     * 先排除对子，然后求最大和最小的牌面之差就行了，小于等于4就肯定是顺子
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0 && nums[i] == nums[i - 1])
                return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                return nums[nums.length - 1] - nums[i] <= 4;
            }
        }
        return false;
    }
}
