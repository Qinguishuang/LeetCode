package lcof.No_41_60;

public class No57 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        if (nums == null || nums.length == 0)
            return ans;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                ans[0] = nums[low];
                ans[1] = nums[high];
            } else if (nums[low] + nums[high] > target) {
                high --;
            } else {
                low ++;
            }
        }
        return ans;
    }
}
