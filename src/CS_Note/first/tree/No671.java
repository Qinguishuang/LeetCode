package CS_Note.first.tree;

import tree.TreeNode;

public class No671 {
    private int min = 0;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return 0;
        min = root.val;
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return min;
        if (root.val > min)
            return root.val;
        return Math.min(dfs(root.left), dfs(root.right));
    }
}
