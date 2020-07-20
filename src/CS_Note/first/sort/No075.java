package CS_Note.first.sort;

public class No075 {
    public void sortColors(int[] nums) {
        int l = -1, r = nums.length, m = 0;
        while (m < r) {
            if (nums[m] == 0) {
                swap(nums,++ l, m++);
            } else if (nums[m] == 2) {
                swap(nums, --r, m);
            } else {
                m ++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
