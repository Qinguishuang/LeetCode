package lcof.No_41_60;


public class No51 {
    private int count = 0;
    private int[] tmp;

    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int l, int h) {
        if (l < h) {
            int mid = l + (h - l) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, h);
            merge(nums, l, mid, h);
        }
    }

    private void merge(int[] nums, int l, int mid, int h) {
        int i = l, j = mid + 1, k = l;
        while (i <= mid || j <= h) {
            if (i > mid) {
                tmp[k] = nums[j++];
            } else if (j > h) {
                tmp[k] = nums[i++];
            } else if (nums[i] <= nums[j]) {
                tmp[k] = nums[i++];
            } else {
                tmp[k] = nums[j++];
                count += (mid - i + 1);
            }
            k++;
        }
        System.arraycopy(tmp, l, nums, l, h - l + 1);
    }

}
