package cz;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No173 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return ans;
        }
        sum -= root.val;
        tmp.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                ans.add(new ArrayList<>(tmp));
            }
        }
        if (root.left != null)
            pathSum(root.left, sum);
        if (root.right != null)
            pathSum(root.right, sum);
        tmp.remove(tmp.size() - 1);
        return ans;

    }


}
