package CS_Note.second.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No491 {

    private HashSet<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>(ans);
        List<Integer> list = new ArrayList<>();
        backTracing(list, 0, nums);
        return new ArrayList<>(ans);
    }

    private void backTracing(List<Integer> list, int i, int[] nums) {
        if (list.size() > 1) {
            ans.add(new ArrayList<>(list));
        }
        for (int j = i; j < nums.length; j++) {
            if (list.size() == 0 || nums[j] > list.get(list.size() - 1)) {
                list.add(nums[j]);
                backTracing(list, j + 1, nums);
                list.remove(list.size() - 1);
            }
        }

    }
}
