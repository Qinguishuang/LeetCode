package lcof.No_41_60;

import java.util.HashMap;
import java.util.Map;

public class No56_2 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return 0;
    }
}
