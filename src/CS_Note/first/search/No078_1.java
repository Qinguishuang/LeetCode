package CS_Note.first.search;

import java.util.ArrayList;
import java.util.List;

public class No078_1 {
    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * <p>
     * 说明：解集不能包含重复的子集。
     */

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0)
            return ans;
        List<Integer> tmp = new ArrayList<>();
        backTracing(nums, 0, tmp);
        return ans;
    }

    public void backTracing(int[] nums, int index, List<Integer> tmp) {
        ans.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            backTracing(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
