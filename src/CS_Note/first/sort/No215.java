package CS_Note.first.sort;

public class No215 {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int index = partition(nums, start, end);
            if (index == k) {
                break;
            } else if (index < k) {
                start = index + 1;
            } else {
                end = index - 1;
            }
        }
        return nums[k];
    }


    private int partition(int[] nums, int start, int end) {
        int tmp = nums[start];
        int i = start, j = 0;
        while (start < end) {
            while (start < end && nums[end] >= tmp)
                end--;
            nums[start] = nums[end];
            while (start < end && nums[start] <= tmp) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = tmp;
        return start;
    }

}
