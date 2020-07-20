package cz;

public class No260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff ^= nums[i];
        }
        diff &= (-diff); // 保留最右侧不为0的位
        int[] ans = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}
