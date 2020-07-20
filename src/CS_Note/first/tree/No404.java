package CS_Note.first.tree;

import tree.TreeNode;

public class No404 {
    private int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return ans;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return ans;
    }
}
