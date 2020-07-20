package lcof.No_21_40;

import java.util.Arrays;

public class No21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while (l < r) {
                if (nums[r] % 2 == 0) { // 找到最后的奇数
                    r--;
                } else {
                    break;
                }
            }
            while (l < r) {
                if (nums[l] % 2 == 1) { // 找到最前边的偶数
                    l++;
                } else {
                    break;
                }
            }
            if (l < r){
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        No21 n = new No21();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(n.exchange(nums)));
    }
}
