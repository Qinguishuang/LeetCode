package CS_Note.first.bit;

public class No260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) { // 得到两个不重复的数的异或结果
            diff ^= num;
        }
        diff &= -diff; // 得到最右侧不为0的位 (不重复的两个数字最右侧不同的那一位01)
        int[] ans = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) // 那一位为0
                ans[0] ^= num;
            else // 那一位为1
                ans[1] ^= num;
        }
        return ans;
    }
}
