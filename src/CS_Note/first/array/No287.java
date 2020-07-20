package CS_Note.first.array;

public class No287 {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != (i + 1)) {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                } else {
                    //     int tmp1 = nums[i];
                    //     int tmp2 = nums[nums[i] - 1];
                    //     nums[nums[i] - 1] = tmp1;
                    //     nums[i] = tmp2;
                    int tmp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = tmp;

                }
            }
        }
        return 0;
    }

    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        No287 n = new No287();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(n.findDuplicate(nums));
    }
}
