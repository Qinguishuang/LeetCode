package lcof.test;

public class No053 {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums[0] != 0)
            return 0;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == mid) {
                low = mid + 1;
            } else {
                if (nums[mid - 1] == mid - 1)
                    return mid;
                else {
                    high = mid - 1;
                }
            }
        }
        return low;
    }

    public static void main(String[] args) {
        No053 n = new No053();
        int[] nums = {0};
        System.out.println(n.missingNumber(nums));
    }
}
