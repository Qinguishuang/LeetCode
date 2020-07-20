package CS_Note.first.swordToOffer.No_61_80;

import tree.TreeNode;

public class No68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (p.val > q.val) {
            return dfs(root, p.val, q.val);
        } else {
            return dfs(root, q.val, p.val);
        }
    }

    private TreeNode dfs(TreeNode root, int p, int q) {
        if (root.val <= p && root.val >= q) {
            return root;
        } else if (root.val >= p) {
            return dfs(root.left, p, q);
        } else {
            return dfs(root.right, p, q);
        }
    }
}
