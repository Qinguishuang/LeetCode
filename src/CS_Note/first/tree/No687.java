package CS_Note.first.tree;

import tree.TreeNode;

public class No687 {
    /**
     * 最长的路径可能有三种情况：
     * 1.在左子树内部
     * 2.在右子树内部
     * 3.在穿过左子树，根节点，右子树的一条路径中
     */
    private int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        left = (root.left != null && root.left.val == root.val) ? left + 1 : 0;
        right = (root.right != null && root.right.val == root.val) ? right + 1 : 0;
        ans = Math.max(ans, left + right);

        return Math.max(left, right);
    }
}
