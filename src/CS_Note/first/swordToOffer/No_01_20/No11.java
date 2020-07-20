package CS_Note.first.swordToOffer.No_01_20;

public class No11 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * <p>
     * 2 3 4 5 1
     * 0 0 0 1 1
     * 0 0 1 1 0
     */
    public int minNumberInRotateArray(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;
        int ans = nums[0];
        while (low < high) {
            mid = (low + high) / 2;
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                return minNum(nums, low, high);
            }
            if (nums[mid] >= nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return ans;
    }

    public int minNum(int[] nums, int low, int high) {
        int ans = nums[low];
        for (; low <= high; low++) {
            if (ans > nums[low]) {
                ans = nums[low];
            }
        }
        return ans;
    }
}
