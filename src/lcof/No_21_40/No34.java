package lcof.No_21_40;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No34 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return ans;
        List<Integer> tmp = new ArrayList<>();
        path(root, sum, tmp);
        return ans;
    }

    private void path(TreeNode root, int sum, List<Integer> tmp) {
        if (root == null)
            return;

        tmp.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                ans.add(new ArrayList<>(tmp));
            }

        } else {
            path(root, sum, tmp);
            path(root, sum, tmp);

        }
        tmp.remove(tmp.size() - 1);
    }
}
