package CS_Note.first.binarySearch;

public class No540 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(nums));

    }

    public static int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int low = 0, high = nums.length - 1, mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (mid % 2 == 1) { // 使low, mid, high都在偶数位
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
