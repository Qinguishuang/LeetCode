package CS_Note.first.swordToOffer.No_41_60;

import tree.TreeNode;

public class No55_1 {
    /**
     * 输入一棵二叉树，求该树的深度。
     */
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = TreeDepth(root.left) + 1;
        int right = TreeDepth(root.right) + 1;
        return Math.max(left, right);
    }

}
