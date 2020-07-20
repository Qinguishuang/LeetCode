package CS_Note.first.tree;

import tree.TreeNode;

public class No543 {
    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值
     * 。这条路径可能穿过根结点。
     * <p>
     * 每个节点的左右子树的高度和的最大值。
     */
    private int ans = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        getDepth(root);
        return ans - 1;
    }

    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }


}
