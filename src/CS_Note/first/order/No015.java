package CS_Note.first.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No015 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return ans;
            if (i > 0 && nums[i] == nums[i + 1])
                continue;
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] == (-nums[i])) {
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1])
                        low++;
                    while (low < high && nums[high] == nums[high - 1])
                        high--;
                } else if (nums[low] + nums[high] > (-nums[i])) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No015 n = new No015();
        System.out.println(n.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
