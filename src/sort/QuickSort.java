package sort;

import java.util.Arrays;

class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * nums.length);
        }
        System.out.println(Arrays.toString(nums));
        quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partition(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int tmp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= tmp)
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= tmp)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = tmp;
        return left;
    }
}