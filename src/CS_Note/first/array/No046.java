package CS_Note.first.array;

import java.util.ArrayList;
import java.util.List;

public class No046 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] isVisited = null;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return ans;
        isVisited = new boolean[nums.length];
        ArrayList<Integer> tmp = new ArrayList<>();
        backTracing(nums, tmp);
        return ans;
    }

    private void backTracing(int[] nums, ArrayList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
        } else {
            for (int j = 0; j < nums.length; j++) {
                if (!isVisited[j]) {
                    tmp.add(nums[j]);
                    isVisited[j] = true;
                    backTracing(nums, tmp);
                    tmp.remove(tmp.size() - 1);
                    isVisited[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        No046 n = new No046();
        System.out.println(n.permute(new int[]{1, 2, 3}));
    }


}
