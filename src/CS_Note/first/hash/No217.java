package CS_Note.first.hash;

import java.util.HashSet;

public class No217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return false;
            } else {
                set.add(nums[i]);
            }
        }
        return true;
    }
}
