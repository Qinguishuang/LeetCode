package cz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No078 {
    Set<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<List<Integer>>();

        List<Integer> tmp = new ArrayList<>();
        subsets(tmp, 0, nums);

        return new ArrayList<>(ans);
    }

    public void subsets(List<Integer> tmp, int start, int[] nums) {
        ans.add(new ArrayList<>(tmp));
        if (tmp.size() == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            subsets(tmp, i+1, nums);
            tmp.remove(tmp.size() - 1);
        }
    }
}
