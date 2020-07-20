package cz;

import book.chapter4.No04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No046 {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return ans;
        boolean[] isVisited = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, tmp, isVisited);
        return ans;
    }

    private void dfs(int[] nums, List<Integer> tmp, boolean[] isVisited) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]) {
                tmp.add(nums[i]);
                isVisited[i] = true;
                dfs(nums, tmp, isVisited);
                isVisited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        // No046 n = new No046();
        // int[] nums = {1, 2, 3};
        // System.out.println(n.permute(nums));

        No038_ n = new No038_();
        System.out.println(Arrays.toString(n.permutation("abc")));
    }
}

class No038_ {
    Set<String> ans = new HashSet<>();

    public String[] permutation(String s) {
        if (s == null || s.length() == 0)
            return new String[0];
        boolean[] isVisited = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        dfs(s, sb, isVisited);
        String[] res = new String[ans.size()];
        return ans.toArray(res);
    }

    private void dfs(String s, StringBuilder sb, boolean[] isVisited) {
        if (sb.length() == s.length()) {
            ans.add(sb.toString());
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    sb.append(s.charAt(i));

                    dfs(s, sb, isVisited);

                    sb.deleteCharAt(sb.length() - 1);
                    isVisited[i] = false;
                }
            }
        }
    }

}
