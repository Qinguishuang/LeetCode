package CS_Note.second.backtracing;

import java.util.ArrayList;
import java.util.List;

public class No046 {
    private List<List<Integer>> ans = new ArrayList<>();
    private boolean[] isVisited = null;

    public List<List<Integer>> permute(int[] nums) {
        isVisited = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();
        backTrace(tmp, nums);
        return ans;
    }

    private void backTrace(List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        // 回溯
        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                tmp.add(nums[i]);
                backTrace(tmp, nums);
                tmp.remove(nums[i]);
                isVisited[i] = false;
            }
        }
    }
}
