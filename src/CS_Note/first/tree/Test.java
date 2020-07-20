package CS_Note.first.tree;

import tree.TreeNode;

public class Test {

    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] dfs(TreeNode root) {
        int[] ans = new int[2];
        if (root == null)
            return ans;

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // 不包含根节点
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 包含根节点
        ans[1] = left[0] + right[0] + root.val;
        return ans;
    }
}
