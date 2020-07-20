package CS_Note.first.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No040 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0)
            return ans;
        // HashSet<Integer> set = new HashSet<Integer>() {{
        //     for (int i = 0; i < candidates.length; i++) {
        //         add(candidates[i]);
        //     }
        // }};
        // int[] t = new int[set.size()];
        // int i = 0;
        // Iterator<Integer> iterator = set.iterator();
        // while (iterator.hasNext()) {
        //     t[i++] = iterator.next();
        // }
        Arrays.sort(candidates);
        List<Integer> tmp = new ArrayList<>();
        backTracing(tmp, candidates, target, 0, 0);
        return ans;
    }

    public void backTracing(List<Integer> tmp, int[] candidates, int target, int index, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            tmp.add(candidates[i]);

            backTracing(tmp, candidates, target, i + 1, sum + candidates[i]);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        No040 n = new No040();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(n.combinationSum2(candidates, target));
    }
}
