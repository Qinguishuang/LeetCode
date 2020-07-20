package star;

import java.util.Arrays;

public class No034 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};

        int left = find(nums, target, true); // 寻找左边界
        if (left == nums.length || nums[left] != target) { // 没找到目标值
            return ans;
        }
        ans[0] = left;
        ans[1] = find(nums, target, false) ;

        return ans;
    }

    private int find(int[] nums, int target, final boolean left) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target || (left && nums[mid] == target)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        No034 n = new No034();
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 2, 3, 3, 3};
        System.out.println(Arrays.toString(n.searchRange(nums, 3)));
    }

}
