package CS_Note.first.tree;

import tree.TreeNode;

public class No230 {
    private int ans;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;
        dfs(root, k);
        return ans;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null)
            return;

        dfs(root.left, k);
        count++;
        if (count == k) {
            ans = root.val;
            return;
        }
        dfs(root.right, k);
    }
}
