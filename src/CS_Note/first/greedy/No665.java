package CS_Note.first.greedy;

public class No665 {

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 3};
        System.out.println(checkPossibility(nums));
    }

    /**
     * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，
     * 该数组能否变成一个非递减数列。
     * [1, 2, 5, 3, 4] 5变小
     * [1, 2, 0, 4, 5] 0变大
     */
    public static boolean checkPossibility(int[] nums) {
        if (nums.length <= 2)
            return true;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if ((i - 1 >= 0) && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
                count--;
                if (count < 0)
                    return false;
            }

        }
        return true;
    }
}
