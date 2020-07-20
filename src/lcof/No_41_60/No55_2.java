package lcof.No_41_60;

import tree.TreeNode;

public class No55_2 {
    private boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        getDepth(root);
        return isBalance;
    }

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.left) + 1;
        int right = getDepth(root.right) + 1;
        if (Math.abs(left - right) > 1)
            isBalance = false;
        return Math.max(left, right);
    }
}
