package CS_Note.first.swordToOffer.No_01_20;

public class No03 {
    /**
     * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
     * 请找出数组中任意一个重复的数字。
     */
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        int i = 0;
        while (i < length) {
            if (nums[i] == i) {
                i++;
            } else if (nums[nums[i]] != i) {
                swap(nums, i, nums[i]);
            } else {
                duplication[0] = nums[i];
                return true;
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
