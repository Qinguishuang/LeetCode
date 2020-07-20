package CS_Note.first.array;

public class No485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = 0, j = 0;
        int ans = 0;
        while (j < nums.length) {
            if (nums[j] == 1) {
                i = j;
            } else {
                while (j < nums.length && nums[j] == 0) {
                    j++;
                }
                i = j;
            }
            while (j < nums.length && nums[j] == 1) {
                j++;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0, tmp = 0;
        for (int num : nums) {
            tmp = (num == 0 ? 0 : tmp + 1);
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}
