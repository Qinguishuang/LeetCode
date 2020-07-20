package sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 6, 2, 7, 0, 9, 4};
        System.out.println(Arrays.toString(nums));
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int index = i - 1;
            while (index >= 0 && nums[index] > tmp) {
                nums[index + 1] = nums[index];
                index--;
            }
            nums[index + 1] = tmp;
        }
    }
}
