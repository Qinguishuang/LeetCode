package cz;

import tree.TreeNode;

public class No110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int l = getHeight(root.left) + 1;
        int r = getHeight(root.right) + 1;
        return Math.max(l, r);
    }
}
