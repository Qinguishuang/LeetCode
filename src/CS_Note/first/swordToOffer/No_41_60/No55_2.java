package CS_Note.first.swordToOffer.No_41_60;

import tree.TreeNode;

public class No55_2 {
    /**
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     */
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        return isBalanced;
    }

    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = getDepth(root.left) + 1;
        int right = getDepth(root.right) + 1;
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return Math.max(left, right) + 1;
    }

}
