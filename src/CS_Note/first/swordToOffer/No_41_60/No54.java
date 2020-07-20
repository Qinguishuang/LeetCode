package CS_Note.first.swordToOffer.No_41_60;

import tree.TreeNode;

public class No54 {
    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。
     */

    private TreeNode ans;
    private int count = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        inOrder(pRoot, k);
        return ans;
    }

    public void inOrder(TreeNode root, int k) {
        if (root == null || k >= count)
            return;
        inOrder(root.left, k);
        count++;
        if (count == k) {
            ans = root;
        }
        inOrder(root.right, k);
    }


}
