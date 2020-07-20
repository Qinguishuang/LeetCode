package lcof.No_41_60;

import tree.TreeNode;

public class No54 {
    private int num = 0;
    private TreeNode ans = null;

    public int kthLargest(TreeNode root, int k) {
        inOrder(root, k);
        return ans.val;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null)
            return;

        inOrder(root.right, k);

        num++;
        if (k == num) {
            ans = root;
            return;
        }

        inOrder(root.left, k);
    }
}
