package lcof.No_21_40;

public class No39 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                count ++;
            } else {
                count--;
                if (count < 0) {
                    last = nums[i];
                    count = 1;
                }
            }
        }
        return last;
    }
}
