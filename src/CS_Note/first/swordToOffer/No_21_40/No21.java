package CS_Note.first.swordToOffer.No_21_40;

public class No21 {
    /**
     * 调整数组顺序使奇数位于偶数前面
     */
    public void reOrderArray(int[] nums) {
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1)
                count++;
        }
        int index = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] % 2 == 1) {
                nums[index++] = tmp[i];
            } else {
                nums[count++] = tmp[i];
            }
        }
    }
}
