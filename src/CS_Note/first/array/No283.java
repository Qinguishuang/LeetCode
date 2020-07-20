package CS_Note.first.array;

public class No283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int zeroPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroPos++] = nums[i];
            }
        }
        for (int i = zeroPos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                int tmp = nums[i];
                nums[i] = nums[i - zeroCount];
                nums[i - zeroCount] = tmp;
            }
        }
    }
}
