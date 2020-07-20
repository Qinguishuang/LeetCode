package cz;

import java.util.Arrays;

public class No215 {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        if (nums == null || nums.length == 0 || k < 0 || k > nums.length)
            return 0;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int index = partition(nums, start, end);
            if (index == k)
                break;
            else if (index < k) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }

        return nums[k];
    }

    void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int index = partition(nums, start, end);
            quickSort(nums, start, index - 1);
            quickSort(nums, index + 1, end);

        }
    }

    private int partition(int[] nums, int start, int end) {
        int tmp = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= tmp)
                end--;
            nums[start] = nums[end];
            while (start < end && nums[start] <= tmp)
                start++;
            nums[end] = nums[start];
        }
        nums[start] = tmp;
        return start;
    }

    public static void main(String[] args) {
        No215 n = new No215();
        int[] nums = {3, 2, 5, 1, 4};
        System.out.println(Arrays.toString(nums));
        n.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
// 快速排序， 归并排序
