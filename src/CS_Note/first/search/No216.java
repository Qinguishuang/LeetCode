package CS_Note.first.search;

import java.util.ArrayList;
import java.util.List;

public class No216 {
    /**
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
     * 并且每种组合中不存在重复的数字。
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0)
            return ans;
        List<Integer> tmp = new ArrayList<>();
        backTracing(n, k, 0, tmp, 1);
        return ans;
    }

    public void backTracing(int n, int k, int sum, List<Integer> tmp, int index) {
        if (sum == n && tmp.size() == k) {
            ans.add(new ArrayList<>(tmp));
        } else if (sum > n || tmp.size() > k) {
        } else {
            for (int i = index; i <= 9; i++) {
                tmp.add(i);
                backTracing(n, k, sum + i, tmp, i+1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
