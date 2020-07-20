package CS_Note.first.binarySearch;

public class No034 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null)
            return null;
        if (nums.length == 0)
            return new int[]{-1, -1};

        int[] ans = new int[2];
        int left = findLeft(nums, target);
        if (nums[left] == target) {
            ans[0] = left;
            ans[1] = findRight(nums, target);
        } else {
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }

    public int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
