package lcof.No_41_60;

public class No53 {
    public int search(int[] nums, int target) {

        int left = find(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return 0;
        }
        int right = find(nums, target, false) - 1;
        return right - left + 1;
    }

    private int find(int[] nums, int target, final boolean isLeft) {
        int low = 0;
        int high = nums.length-1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target || (isLeft && nums[mid] == target)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        No53 n = new No53();
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(n.search(nums, 8));
    }
}
