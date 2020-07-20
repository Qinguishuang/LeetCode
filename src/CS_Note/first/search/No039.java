package CS_Note.first.search;

import java.util.ArrayList;
import java.util.List;

public class No039 {
    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     * candidates 中的数字可以无限制重复被选取。
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length <= 0 || target < 0) {
            return ans;
        }
        List<Integer> tmp = new ArrayList<>();
        backTracing(tmp, candidates, 0, 0, target);
        return ans;
    }

    public void backTracing(List<Integer> tmp, int[] candidates, int i, int sum, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(tmp));
        } else if (sum > target) {
        } else {
            for (; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                backTracing(tmp, candidates, i, sum + candidates[i], target);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        No039 n = new No039();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(n.combinationSum(candidates, target));
    }
}
