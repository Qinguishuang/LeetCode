package CS_Note.first.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No491 {
    private HashSet<List<Integer>> ans = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        List<Integer> tmp = new ArrayList<>();
        backTracing(tmp, 0, nums);

        return new ArrayList<>(ans);
    }

    private void backTracing(List<Integer> tmp, int i, int[] nums) {
        if (tmp.size() > 1) {
            ans.add(new ArrayList<>(tmp));
        }
        for (int j = i; j < nums.length; j++) {
            if (tmp.size() == 0 || nums[j] >= tmp.get(tmp.size() - 1)) {
                tmp.add(nums[j]);
                backTracing(tmp, j+1, nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        No491 n = new No491();
        System.out.println(n.findSubsequences(new int[]{4, 3, 2, 1}));
    }
}
