package cz;

import tree.TreeNode;

public class No129 {
    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int tmp) {
        if (root != null) {
            tmp = tmp * 10 + root.val;
            if (root.left == null && root.right == null) {
                ans += tmp;
            }
            dfs(root.left, tmp);
            dfs(root.right, tmp);
        }
    }


}
