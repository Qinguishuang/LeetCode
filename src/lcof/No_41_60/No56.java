package lcof.No_41_60;

public class No56 {
    public int[] singleNumbers(int[] nums) {
        int[] ans = new int[2];

        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        num &= -num;
        // num  0000 1000  -> 1111 0111 + 1 = 1111 1000
        // -num 1111 1000
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & num) == 0) {
                ans[0] ^= nums[i];
            } else {
                ans[1] ^= nums[i];
            }
        }
        return ans;
    }
}
