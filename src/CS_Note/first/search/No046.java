package CS_Note.first.search;

import java.util.ArrayList;
import java.util.List;

public class No046 {
    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     */
    private ArrayList<List<Integer>> ans = new ArrayList<>();
    private boolean[] isVisited = null;

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return ans;
        }
        isVisited = new boolean[nums.length];
        ArrayList<Integer> tmp = new ArrayList<>();
        backtracking(tmp, nums);
        return ans;
    }

    public void backtracking(List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                tmp.add(nums[i]);
                backtracking(tmp, nums);
                tmp.remove(tmp.size() - 1);
                isVisited[i] = false;
            }
        }
    }
}
